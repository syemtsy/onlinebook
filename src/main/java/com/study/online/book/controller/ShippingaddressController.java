package com.study.online.book.controller;

import com.study.online.book.service.UserService;
import com.study.online.book.dao.entity.Shippingaddress;
import com.study.online.book.service.ShippingaddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ShippingaddressController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShippingaddressService shippingaddressService;

    @RequestMapping(value = "/shippingaddresslist", method = RequestMethod.GET)
    public List<Shippingaddress> getshippingaddresslist(HttpSession session) {
        String username = (String) session.getAttribute("name");
        Long Uid = userService.findByName(username).getUid();
        return shippingaddressService.findAllAddressByUid(Uid);
    }

    @RequestMapping("/shippingaddress")
    public boolean shippingaddressDefault(HttpSession session,@RequestParam Integer defult) {
        String username = (String) session.getAttribute("name");
        Long Uid = userService.findByName(username).getUid();
        return shippingaddressService.setDefultAddress(defult, Uid);

    }
}
