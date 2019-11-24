package com.study.online.book.service.impl;

import com.study.online.book.dao.mapper.ShippingaddressMapper;
import com.study.online.book.dao.entity.Shippingaddress;
import com.study.online.book.service.ShippingaddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ShippingaddressServiceimpl implements ShippingaddressService {
    @Resource
    private ShippingaddressMapper shippingaddressMapper;
    @Override
    public boolean setDefultAddress(Integer addressId,Long uid) {
        shippingaddressMapper.updateNoDefultByUid(uid);
        if (shippingaddressMapper.updateDefultByUidAndAddressId(addressId, uid) == 1) {

            return true;
        }
        return false;
    }


    @Override
    public List<Shippingaddress> findAllAddressByUid(Long uid) {
      return   shippingaddressMapper.selectAllByUid(uid);
    }
}
