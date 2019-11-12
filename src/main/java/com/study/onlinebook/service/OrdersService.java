package com.study.onlinebook.service;

import com.alipay.api.AlipayApiException;
import com.study.onlinebook.dao.entity.Orders;
import com.study.onlinebook.dao.entity.OrdersVo;
import com.study.onlinebook.dao.entity.OrdersVoVo;

import java.util.List;

public interface OrdersService {

    String save(Long uid, List<String> info);

    boolean IsPay(Long orderid) throws AlipayApiException;
     List<Orders> findAllByUid(Long uid, Integer pageable);

    OrdersVoVo findByUid(Long uid, Long orderid);


    String pay(Long uid, Long orderid, String msg,Integer addressid) throws AlipayApiException;



    List<Orders> findAll(Integer page);
}
