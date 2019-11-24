package com.study.online.book.controller;

import com.study.online.book.common.api.CommonResult;
import com.study.online.book.service.UserService;
import com.study.online.book.dao.entity.User;
import com.study.online.book.dao.entity.Userinfo;
import com.study.online.book.service.UserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@Api(tags = "UserinfoController",description = "用户信息管理")
@Controller
public class UserinfoController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserinfoService userinfoService;

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Userinfo> getuserinfo(HttpServletRequest request) {
        String principal = (String) request.getSession().getAttribute("name");
//        Subject subject = SecurityUtils.getSubject();
//        String principal = (String)subject.getPrincipal();
        User user = userService.findByName(principal);
        return  CommonResult.success(userinfoService.findByuid(user.getUid()));
    }



}
