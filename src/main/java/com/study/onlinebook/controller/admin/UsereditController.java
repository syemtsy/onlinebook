package com.study.onlinebook.controller.admin;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.study.onlinebook.dao.entity.UserVo;
import com.study.onlinebook.dao.entity.Userinfo;
import com.study.onlinebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UsereditController {
    @Autowired
    private UserService userService;

    @RequestMapping("/admin/userlist")
    public List<UserVo> getUserlist(@RequestParam Integer page) {
        return userService.findAllUserVo(page);

    }

    @RequestMapping("/admin/useredit")
    public boolean useredit(@RequestBody UserVo userVo) {
       return userService.updateUserVo(userVo);
    }

    @RequestMapping("/admin/userdel")
    public boolean userdel(Long uid) {
        return userService.delectByUid(uid);
    }

}
