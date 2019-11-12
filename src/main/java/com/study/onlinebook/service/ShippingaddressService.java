package com.study.onlinebook.service;

import com.study.onlinebook.dao.entity.Shippingaddress;

import java.util.List;

public interface ShippingaddressService {
    boolean setDefultAddress(Integer addressid,Long uid);

    List<Shippingaddress> findAllAddressByUid(Long uid);


}
