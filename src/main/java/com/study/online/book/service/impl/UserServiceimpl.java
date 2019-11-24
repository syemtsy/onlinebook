package com.study.online.book.service.impl;


import com.github.pagehelper.PageHelper;
import com.study.online.book.service.MailService;
import com.study.online.book.service.UserService;
import com.study.online.book.dao.entity.DataValid;
import com.study.online.book.dao.entity.User;
import com.study.online.book.dao.entity.UserVo;
import com.study.online.book.dao.mapper.UserMapper;
import com.study.online.book.dao.mapper.UserinfoMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service

public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserinfoMapper userinfoMapper;
    private static final Integer pageSize = 10;
    @Autowired
    private MailService mailService;
    @Override
    public User findByName(String name) {
        return userMapper.findUserByName(name);
    }


    @Override
    public boolean save(String username, String password) {
        ByteSource salt = ByteSource.Util.bytes(username);
        String newPs = new SimpleHash("MD5", password, salt, 2).toHex();
        if (userMapper.countByName(username) == 0) {
            Long uid = 123456L + userMapper.count();
            User user = new User();
            user.setUid(uid);
            user.setName(username);
            user.setPassword(newPs);
            user.setSalt(username);
            userMapper.insert(user);
            return true;
        }
        return false;
    }

    @Override
    public List<UserVo> findAllUserVo(Integer page) {
        PageHelper.startPage(page, pageSize);
        return userMapper.selectAllUserVo();
    }

    @Override
    public boolean updateUserVo(UserVo userVo) {
        if (userMapper.updateNameByUid(userVo) != 0) {
            if (userinfoMapper.selectByPrimaryKey(userVo.getUid()) != null) {
                if(userinfoMapper.updateByPrimaryKey(userVo.getUserinfo()) != 0) {
                    return true;
                }
            }
            else {
                userinfoMapper.insert(userVo.getUserinfo());
            }

        }

        return false;
    }

    @Override
    public boolean delectByUid(Long uid) {
        if (userMapper.deleteByUid(uid) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public String register(DataValid dataValid, BindingResult result, HttpSession session) {
        int verificacode = (int) session.getAttribute("code");
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return "error:" + list.get(0).getDefaultMessage();

        } else {
            if (findByName(dataValid.getUsername()) == null && dataValid.getVerificacode() == verificacode) {
                save(dataValid.getUsername(), dataValid.getPassword());
                User user = findByName(dataValid.getUsername());
//               userinfoMapper.saveEmail(((User) user).getUid(), dataValid.getEmail());
                return "success";
            } else {
                return "failure";
            }
        }
    }

}
