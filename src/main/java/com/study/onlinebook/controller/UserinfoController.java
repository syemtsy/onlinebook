package com.study.onlinebook.controller;

import com.study.onlinebook.dao.entity.User;
import com.study.onlinebook.dao.entity.Userinfo;
import com.study.onlinebook.service.UserService;
import com.study.onlinebook.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserinfoController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserinfoService userinfoService;
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    @ResponseBody
    public Userinfo getuserinfo(HttpServletRequest request) {
        String principal = (String) request.getSession().getAttribute("name");
//        Subject subject = SecurityUtils.getSubject();
//        String principal = (String)subject.getPrincipal();
        User user = userService.findByName(principal);
        return  userinfoService.findByuid(user.getUid());
    }



}
