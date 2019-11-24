package com.study.online.book.dao.mapper;

import com.study.online.book.dao.entity.Shopcat;
import com.study.online.book.dao.entity.ShopcatVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ShopcatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shopcat record);

    Shopcat selectByPrimaryKey(Integer id);

    List<Shopcat> selectAll();

    int updateByPrimaryKey(Shopcat record);

    List<ShopcatVo> findAllByUid(Long uid);

    int deleteByUidAndIsbn(Long uid, Long isbn);

    int addNumberByisbnanduid(Long uid, Long isbn, int number);

    Shopcat findByUidAndIsbn(Long uid, Long isbn);

    int updateByUidAndIsbn(Long isbn, int number, Long uid);
}