package com.study.onlinebook.dao.mapper;

import com.study.onlinebook.dao.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface InventoryMapper {
    int deleteByPrimaryKey(Long isbn);

    int insert(Inventory record);

    Inventory selectByPrimaryKey(Long isbn);

    List<Inventory> selectAll();

    int updateByPrimaryKey(Inventory record);

    int addNumber(int number, Long isbn);
}