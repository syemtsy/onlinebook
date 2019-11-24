package com.study.online.book.service.impl;

import com.study.online.book.dao.entity.Userinfo;
import com.study.online.book.dao.mapper.UserinfoMapper;
import com.study.online.book.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserinfoServiceimpl implements UserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Override
    public boolean saveEmail(Long uid, String email) {
        Userinfo userinfo = new Userinfo();
        userinfo.setUid(uid);
        userinfo.setEmail(email);
//        if (userinfoDao.save(userinfo)!=null) {
//            return true;
//        }
        return false;

    }

    @Override
    public Userinfo findByuid(Long uid) {
        return userinfoMapper.findUserinfoByUid(uid);
    }


}
