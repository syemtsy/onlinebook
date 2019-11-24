package com.study.online.book.dao.entity;

import lombok.Data;

@Data
public class UserVo extends User {
    private Userinfo userinfo;
}
