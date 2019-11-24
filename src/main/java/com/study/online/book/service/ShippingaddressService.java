package com.study.online.book.service;

import com.study.online.book.dao.entity.Shippingaddress;

import java.util.List;

public interface ShippingaddressService {
    boolean setDefultAddress(Integer addressid,Long uid);

    List<Shippingaddress> findAllAddressByUid(Long uid);


}
