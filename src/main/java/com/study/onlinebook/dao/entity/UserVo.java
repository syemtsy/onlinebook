package com.study.onlinebook.dao.entity;

import lombok.Data;

@Data
public class UserVo extends User {
    private Userinfo userinfo;
}
