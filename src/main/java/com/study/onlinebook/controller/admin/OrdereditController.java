package com.study.onlinebook.controller.admin;

import com.study.onlinebook.dao.entity.Orders;
import com.study.onlinebook.dao.entity.OrdersVoVo;
import com.study.onlinebook.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdereditController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/admin/orderlist")
    public List<Orders> getOrdersList(@RequestParam Integer page) {
      return   ordersService.findAll(page);
    }
}
