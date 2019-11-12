package com.study.onlinebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/login";
    }
    @RequestMapping(value = "/login")
    public String login() {
        return "/login";
    }
    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }
    @RequestMapping("/myorder")
    public String myorder() {
        return "/myorder";
    }
    @RequestMapping("/myshopcatt")
    public String myshopcat() {
        return "/myshopcat";
    }
    @RequestMapping("/search")
    public String search() {
        return "/search";
    }
    @RequestMapping("/orderform")
    public String orderform() {
        return "/cartorderform";
    }
    @RequestMapping("/pay")
    public String pay() {
        return "/pay";
    }
}
