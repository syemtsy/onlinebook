package com.study.onlinebook.service;


import com.study.onlinebook.dao.entity.Book;
import com.study.onlinebook.dao.entity.BookVo;

import java.util.List;


public interface BookService {

    List<Book> findAllBynameOrauthor(String string, int select, Integer pageable);

    List<Book> findAll(Integer pageable);

    Book findByisbn(Long isbn);

    BookVo findBookVoByisbn(Long isbn);
}
