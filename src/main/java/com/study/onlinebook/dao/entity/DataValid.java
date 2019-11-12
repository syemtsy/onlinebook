package com.study.onlinebook.dao.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Data
public class DataValid {

        @Length(min = 6,max = 12,message = "用户名必须在6-12字节")
        private String username;
        @Length(min = 6,max = 20,message = "密码必须在6-20字节之内")
        private String password;
        @Length(min = 6,max = 20,message = "密码必须在6-20字节之内")
        private String repassword;
        @Email(message = "请输入正确的邮件格式")
        private String email;
        @NotNull(message = "验证码不能为空")
        private int verificacode;
    //   @NotNull(message = "姓名不能为空!")
    //    private String actualname;
    //    @NotNull(message = "性别不能为空!")
    //    private String sex;
    //    @NotNull(message = "电话不能为空")
    //    private String tel;
     }
