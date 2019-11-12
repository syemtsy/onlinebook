package com.study.onlinebook.service;

import com.study.onlinebook.dao.entity.DataValid;
import com.study.onlinebook.dao.entity.User;
import com.study.onlinebook.dao.entity.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface UserService {

    User findByName(String name);

    boolean save(String username, String password);


    List<UserVo> findAllUserVo(Integer page);

    boolean updateUserVo(UserVo userVo);

    boolean  delectByUid(Long uid);


    String register(DataValid dataValid, BindingResult result, HttpSession session);
}
