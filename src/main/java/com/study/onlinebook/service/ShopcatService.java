package com.study.onlinebook.service;

import com.study.onlinebook.dao.entity.Shopcat;
import com.study.onlinebook.dao.entity.ShopcatVo;

import java.util.List;

public interface ShopcatService {

    List<ShopcatVo> findByUid(Long uid, Integer pageable);

    boolean deleteByUid(Long uid, Long isbn);

    void save(Shopcat shopcat);

    int updateByisbn(Long uid, Long isbn, int number);

    Shopcat findByuidAndisbn(Long uid, Long isbn);

    boolean putShopinfo(String info, Long uid);

    void updataShopinfo(List<String> info, Long uid);

}
