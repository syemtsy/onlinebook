package com.study.online.book.controller;

import com.study.online.book.service.UserService;
import com.study.online.book.dao.entity.Shippingaddress;
import com.study.online.book.service.ShippingaddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(tags = "ShippingaddressController",description = "收货人管理")
public class ShippingaddressController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShippingaddressService shippingaddressService;
    @ApiOperation("根据session中的用户信息获取收货人所有地址")
    @RequestMapping(value = "/shippingaddresslist", method = RequestMethod.GET)
    public List<Shippingaddress> getshippingaddresslist(HttpSession session) {
        String username = (String) session.getAttribute("name");
        Long Uid = userService.findByName(username).getUid();
        return shippingaddressService.findAllAddressByUid(Uid);
    }
    @ApiOperation("设置收货人默认地址")
    @RequestMapping("/shippingaddress")
    public boolean shippingaddressDefault(HttpSession session,
                                          @ApiParam("收获地址索引") @RequestParam Integer index) {
        String username = (String) session.getAttribute("name");
        Long Uid = userService.findByName(username).getUid();
        return shippingaddressService.setDefultAddress(index, Uid);

    }
}
