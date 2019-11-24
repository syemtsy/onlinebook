package com.study.online.book.service.impl;


import com.github.pagehelper.PageHelper;
import com.study.online.book.service.BookService;
import com.study.online.book.dao.entity.Book;
import com.study.online.book.dao.entity.BookVo;
import com.study.online.book.dao.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class BookServiceimpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    private final static int pageable_size = 15;



    @Override
    public List<Book> findAllBynameOrauthor(String string, int select, Integer pageable) {

        if (select == 0) {
                     PageHelper.startPage(pageable, pageable_size);
         return   bookMapper.findAllByBooknameLikeOrAuthorLike(string, string);
        }
        if (select == 1) {
            PageHelper.startPage(pageable, pageable_size);
            return bookMapper.findAllByBooknameLikeOrAuthorLike(string, "");
        }
        if (select == 2) {
            PageHelper.startPage(pageable, pageable_size);
            return bookMapper.findAllByBooknameLikeOrAuthorLike("", string);
        }
        return null;
    }

    @Override
    public List<Book> findAll(Integer pageable) {
        PageHelper.startPage(pageable, pageable_size);
        return bookMapper.selectAll();
    }

    @Override
    public Book findByisbn(Long isbn) {
        return bookMapper.findByIsbn(isbn);
    }
    @Override
    public BookVo findBookVoByisbn(Long isbn) {

        return bookMapper.findBookVoByIsbn(isbn);
    }
}
