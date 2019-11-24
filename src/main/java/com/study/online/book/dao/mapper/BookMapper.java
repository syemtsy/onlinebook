package com.study.online.book.dao.mapper;

import com.study.online.book.dao.entity.Book;
import com.study.online.book.dao.entity.BookVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    Book selectByPrimaryKey(Integer id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);

    List<Book> findAllByBooknameLikeOrAuthorLike(String bookname, String author);

    Book findByIsbn(Long isbn);

    BookVo findBookVoByIsbn(Long isbn);
}