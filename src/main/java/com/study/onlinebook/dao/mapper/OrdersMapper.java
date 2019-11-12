package com.study.onlinebook.dao.mapper;

import com.study.onlinebook.dao.entity.Orders;
import com.study.onlinebook.dao.entity.OrdersVo;
import com.study.onlinebook.dao.entity.OrdersVoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
@Mapper
public interface OrdersMapper {
    int insert(Orders record);

    List<Orders> selectAll();

    int UpdateStatus(int status, Date update_time, Long orderid);

    List<Orders> findAllByUid(Long uid);

    OrdersVoVo findOrdersVoByOrderid(Long uid,Long orderid);

    Integer updataMsgandAddressByOrderid(Long orderid, String msg,Integer addressid);

}