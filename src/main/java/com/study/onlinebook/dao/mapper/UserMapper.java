package com.study.onlinebook.dao.mapper;

import com.study.onlinebook.dao.entity.User;
import com.study.onlinebook.dao.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User findUserByName(String name);

    int countByName(String name);

    int count();

    List<UserVo> selectAllUserVo();

    int deleteByUid(Long uid);

    int updateNameByUid(User user);
}