package com.study.onlinebook.controller;

import com.alipay.api.AlipayApiException;
import com.study.onlinebook.dao.entity.Orders;
import com.study.onlinebook.dao.entity.OrdersVo;
import com.study.onlinebook.dao.entity.OrdersVoVo;
import com.study.onlinebook.service.OrdersService;
import com.study.onlinebook.service.ShopcatService;
import com.study.onlinebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShopcatService shopcatService;
    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String addorder(@RequestParam (required = false, value = "orderinfo[]")List<String> info ,@RequestParam String source ,HttpServletRequest request)  {
        String name = (String) request.getSession().getAttribute("name");
      Long uid=  userService.findByName(name).getUid();
        String result=ordersService.save(uid, info);
        if (result != null) {
            if (source.equals("shopcat")) {
                shopcatService.updataShopinfo(info, uid);
            }

        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public boolean IsPay(@RequestParam Long orderid) throws AlipayApiException {
        return ordersService.IsPay(orderid);
    }


    @ResponseBody
    @RequestMapping(value = "/orderlist", method = RequestMethod.GET)
    public List<Orders> orderlist(Integer pageable, HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        return ordersService.findAllByUid(uid, pageable);
    }


    @ResponseBody
    @RequestMapping(value = "/ordersid", method = RequestMethod.GET)
    public OrdersVoVo ordersid(Long orderid, HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        return ordersService.findByUid(uid, orderid);
    }


    @ResponseBody
    @RequestMapping(value = "/ordersid", method = RequestMethod.POST)
    public String payUrl(Long orderid,String msg,Integer addressid,HttpServletRequest request) throws AlipayApiException {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        return ordersService.pay(uid, orderid, msg,addressid);
    }


}
