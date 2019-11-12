package com.study.onlinebook.service;


import com.study.onlinebook.dao.entity.Userinfo;

public interface UserinfoService {
    boolean saveEmail(Long uid, String email);

    Userinfo findByuid(Long uid);
}
