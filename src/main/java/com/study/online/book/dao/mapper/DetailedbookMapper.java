package com.study.online.book.dao.mapper;

import com.study.online.book.dao.entity.Detailedbook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DetailedbookMapper {
    int deleteByPrimaryKey(Long isbn);

    int insert(Detailedbook record);

    Detailedbook selectByPrimaryKey(Long isbn);

    List<Detailedbook> selectAll();

    int updateByPrimaryKey(Detailedbook record);
}