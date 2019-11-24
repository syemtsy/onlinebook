package com.study.online.book.controller;

import com.alipay.api.AlipayApiException;
import com.study.online.book.service.OrdersService;
import com.study.online.book.service.ShopcatService;
import com.study.online.book.service.UserService;
import com.study.online.book.dao.entity.Orders;
import com.study.online.book.dao.entity.OrdersVoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Api(tags = "订单管理", description = "订单管理")
@Controller
public class OrderController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShopcatService shopcatService;

    @ApiOperation("添加一个订单")
    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String addorder(@ApiParam("商品*数字的数组") @RequestParam(required = false, value = "orderinfo[]")List<String> info,
                           @ApiParam("来源-1.shopcat /购物车")@RequestParam String source,
                           HttpServletRequest request) {

        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        String result = ordersService.save(uid, info);
        if (result != null) {
            if (source.equals("shopcat")) {
                shopcatService.updataShopinfo(info, uid);
            }

        }
        return result;
    }
    @ApiOperation("检测订单是否支付")
    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public boolean IsPay(@ApiParam("订单id")@RequestParam Long orderid) throws AlipayApiException {
        return ordersService.IsPay(orderid);
    }

    @ApiOperation("查询订单列表")
    @ResponseBody
    @RequestMapping(value = "/orderlist", method = RequestMethod.GET)
    public List<Orders> orderlist(Integer pageable, HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        return ordersService.findAllByUid(uid, pageable);
    }

    @ApiOperation("查询订单详情")
    @ResponseBody
    @RequestMapping(value = "/ordersid", method = RequestMethod.GET)
    public OrdersVoVo ordersid(Long orderid, HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        return ordersService.findByUid(uid, orderid);
    }

    @ApiOperation("获取订单支付地址")
    @ResponseBody
    @RequestMapping(value = "/ordersid", method = RequestMethod.POST)
    public String payUrl(Long orderid,String msg,Integer addressid,HttpServletRequest request) throws AlipayApiException {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        return ordersService.pay(uid, orderid, msg,addressid);
    }


}
