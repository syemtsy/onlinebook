package com.study.online.book.dao.mapper;

import com.study.online.book.dao.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserinfoMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Long uid);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);

    Userinfo findUserinfoByUid(Long uid);

}