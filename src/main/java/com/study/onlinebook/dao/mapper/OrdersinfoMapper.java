package com.study.onlinebook.dao.mapper;

import com.study.onlinebook.dao.entity.OrdersVo;
import com.study.onlinebook.dao.entity.Ordersinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrdersinfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Ordersinfo record);

    Ordersinfo selectByPrimaryKey(Long id);

    List<Ordersinfo> selectAll();

    int updateByPrimaryKey(Ordersinfo record);

}