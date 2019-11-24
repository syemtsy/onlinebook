package com.study.online.book.service;


import com.study.online.book.dao.entity.Book;
import com.study.online.book.dao.entity.BookVo;

import java.util.List;


public interface BookService {

    List<Book> findAllBynameOrauthor(String string, int select, Integer pageable);

    List<Book> findAll(Integer pageable);

    Book findByisbn(Long isbn);

    BookVo findBookVoByisbn(Long isbn);
}
