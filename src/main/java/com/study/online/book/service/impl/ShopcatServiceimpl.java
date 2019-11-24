package com.study.online.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.study.online.book.dao.mapper.ShopcatMapper;
import com.study.online.book.service.ShopcatService;
import com.study.online.book.dao.entity.Shopcat;
import com.study.online.book.dao.entity.ShopcatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopcatServiceimpl implements ShopcatService {
    @Autowired
    private ShopcatMapper shopcatMapper;
   private static final int page_size=10;
    @Override
    public List<ShopcatVo> findByUid(Long uid, Integer pageable) {

        PageHelper.startPage(pageable, page_size);
        return shopcatMapper.findAllByUid(uid);
    }

    @Override
    public boolean deleteByUid(Long uid, Long isbn) {
        if(shopcatMapper.deleteByUidAndIsbn(uid,isbn)!=0){
            return true;
        }
        return false;
    }

    @Override
    public void save(Shopcat shopcat) {
        shopcatMapper.insert(shopcat);
    }
    @Override
    public int updateByisbn(Long uid, Long isbn, int number) {
      return   shopcatMapper.addNumberByisbnanduid(uid,isbn,number);
    }

    @Override
    public Shopcat findByuidAndisbn(Long uid,Long isbn) {
      return   shopcatMapper.findByUidAndIsbn(uid,isbn);
    }

    @Override
    public boolean putShopinfo(String info, Long uid) {
        String[] infoarr = info.split("\\*");
        if (infoarr.length == 2) {
            Long isbn = Long.parseLong(infoarr[0]);
            int number = Integer.parseInt(infoarr[1]);
            if (shopcatMapper.updateByUidAndIsbn(isbn, number, uid) == 1) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void updataShopinfo(List<String> info, Long uid) {
        for (String shopinfo :
                info) {
            if (shopinfo.split("\\*").length == 2) {
                Long isbn = Long.parseLong(shopinfo.split("\\*")[0]);
                shopcatMapper.deleteByUidAndIsbn(uid, isbn);

            }


        }
    }


}
