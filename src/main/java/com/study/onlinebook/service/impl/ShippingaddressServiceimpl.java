package com.study.onlinebook.service.impl;

import com.study.onlinebook.dao.entity.Shippingaddress;
import com.study.onlinebook.dao.mapper.ShippingaddressMapper;
import com.study.onlinebook.service.ShippingaddressService;
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
