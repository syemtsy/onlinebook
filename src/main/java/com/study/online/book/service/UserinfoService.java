package com.study.online.book.service;


import com.study.online.book.dao.entity.Userinfo;

public interface UserinfoService {
    boolean saveEmail(Long uid, String email);

    Userinfo findByuid(Long uid);
}
