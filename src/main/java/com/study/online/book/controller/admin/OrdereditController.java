package com.study.online.book.controller.admin;

import com.study.online.book.service.OrdersService;
import com.study.online.book.dao.entity.Orders;
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
