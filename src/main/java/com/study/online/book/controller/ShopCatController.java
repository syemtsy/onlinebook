package com.study.online.book.controller;

import com.study.online.book.common.api.CommonResult;
import com.study.online.book.service.ShopcatService;
import com.study.online.book.service.UserService;
import com.study.online.book.dao.entity.Shopcat;
import com.study.online.book.dao.entity.ShopcatVo;
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

@Api(tags = "ShopCatController",description = "管理购物车")
@Controller
public class ShopCatController {
    @Autowired
    private ShopcatService shopcatService;
    @Autowired
    private UserService userService;

    @ApiOperation("获取自己的购物项分页列表")
    @ResponseBody
    @RequestMapping(value = "/myshopcat", method = RequestMethod.GET)
    public CommonResult<List<ShopcatVo>> getmyshopcat(@ApiParam("第几页") @RequestParam Integer pageable,
                                                     HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
//        Subject subject = SecurityUtils.getSubject();
//      String name= (String) subject.getPrincipal();
        Long uid = userService.findByName(name).getUid();
        return CommonResult.success(shopcatService.findByUid(uid, pageable));
    }

    @ApiOperation("删除购物项")
    @ResponseBody
    @RequestMapping(value = "/myshopcat", method = RequestMethod.DELETE)
    public CommonResult<String> deleteshopcat(@ApiParam("书籍编号")@RequestParam Long isbn,
                                HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        shopcatService.deleteByUid(uid, isbn);
        return CommonResult.success("true");
    }

    @ApiOperation("增加购物项")
    @ResponseBody
    @RequestMapping(value = "/shopcat", method = RequestMethod.POST)
    public CommonResult<Boolean> addshopcat(@ApiParam("购物项字符串数组/改成json") String info, HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
//        Subject subject = SecurityUtils.getSubject();
//        String name= (String) subject.getPrincipal();
        Long uid = userService.findByName(name).getUid();
        String[] shopinfo = info.split(",");
        for (String s : shopinfo) {
            String[] a = s.split("\\*");
            if (shopcatService.findByuidAndisbn(uid, Long.parseLong(a[0])) == null) {
                Shopcat shopcat = new Shopcat();
                shopcat.setUid(uid);
                shopcat.setIsbn(Long.parseLong(a[0]));
                shopcat.setQuantity(Integer.parseInt(a[1]));

                shopcatService.save(shopcat);
            } else {
                shopcatService.updateByisbn(uid, Long.parseLong(a[0]), Integer.parseInt(a[1]));
            }
        }
        return CommonResult.success(true);
    }
    @ApiOperation("更新购物项")
    @ResponseBody
    @RequestMapping(value = "/shopcat", method = RequestMethod.PUT)
    public CommonResult<Boolean> putshopcat(@RequestParam String shopinfo,HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        return CommonResult.success(shopcatService.putShopinfo(shopinfo, uid));
    }
}
