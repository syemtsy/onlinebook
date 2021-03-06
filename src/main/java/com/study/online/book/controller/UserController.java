package com.study.online.book.controller;

import com.study.online.book.common.api.CommonResult;
import com.study.online.book.service.MailService;
import com.study.online.book.service.UserService;
import com.study.online.book.dao.entity.DataValid;
import com.study.online.book.dao.entity.User;
import com.study.online.book.service.UserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Random;

@Api(tags = "UserController",description = "用户登陆注册管理")
@Controller
public class UserController {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserinfoService userinfoService;

    @ApiOperation("用户注册")
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<String> register(@Valid DataValid dataValid, BindingResult result, HttpSession session) {
     return    CommonResult.success(userService.register(dataValid,result, session));
    }

    @ApiOperation("生成验证码")
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Boolean> code(@RequestParam String email, HttpSession session) {
        int verificacode;
        Random random = new Random();
        verificacode = random.nextInt(8000) + 1000;
        session.setAttribute("code", verificacode);
        System.out.println(verificacode);
        mailService.sendSimpleMail(email, "来自onlinebook的邮箱验证码", String.valueOf(verificacode));
        return CommonResult.success(true);
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Boolean> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.findByName(username);
        if (user != null) {

            String salt = username;
            int hashIterations = 2;
            SimpleHash simpleHash = new SimpleHash("md5", password, ByteSource.Util.bytes(salt), hashIterations);
            if (user.getPassword().equals(simpleHash.toHex())) {
                request.getSession().setAttribute("name", username);
                Cookie cookie = new Cookie("username", username);
                cookie.setPath("/");
                cookie.setMaxAge(-1);
                response.addCookie(cookie);
                return CommonResult.success(true);
            }
        }
        return CommonResult.success(false);

    }

    @ApiOperation("注销")
    @ResponseBody
    @RequestMapping("/loginout")
    public CommonResult<Boolean> loginout(HttpSession session, HttpServletResponse response) {
        session.removeAttribute("name");
        Cookie cookie = new Cookie("sessionid", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        Cookie cookie1 = new Cookie("username", "");
        cookie1.setMaxAge(0);
        cookie1.setPath("/");
        response.addCookie(cookie);
        response.addCookie(cookie1);
        return CommonResult.success(true);
    }

    @ApiOperation("返回用户登陆状态")
    @RequestMapping(value = "/islogin", method = RequestMethod.POST)
    @ResponseBody
    public boolean isLogin(@RequestParam String username, HttpSession session) {
        String sessionuser = (String) session.getAttribute("name");
        if (sessionuser!=""&&sessionuser!=null&&sessionuser.equals(username)) {
            return true;
        }
        return false;
    }
}
