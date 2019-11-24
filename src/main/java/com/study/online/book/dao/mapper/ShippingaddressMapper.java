package com.study.online.book.dao.mapper;

import com.study.online.book.dao.entity.Shippingaddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ShippingaddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shippingaddress record);

    Shippingaddress selectByPrimaryKey(Integer id);

    List<Shippingaddress> selectAll();

    int updateByPrimaryKey(Shippingaddress record);

    void updateNoDefultByUid(Long uid);

    int updateDefultByUidAndAddressId(Integer addressid, Long uid);

    List<Shippingaddress> selectAllByUid(Long uid);

    Integer selectdulfaddress(Long uid);
}