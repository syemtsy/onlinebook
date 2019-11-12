package com.study.onlinebook.controller;

import com.study.onlinebook.dao.entity.Book;
import com.study.onlinebook.dao.entity.BookVo;
import com.study.onlinebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;



    @ResponseBody
    @RequestMapping("/booklist")
    public List<Book> bookPage(@RequestParam Integer pageble_number, @RequestParam String string, @RequestParam int select) {
        return bookService.findAllBynameOrauthor("%"+string+"%",select,pageble_number);
    }


    @RequestMapping("/booklists")
    @ResponseBody
    public List<Book> bookPage(@RequestParam Integer pageble_number) {
        return bookService.findAll(pageble_number);
    }


    @ResponseBody
    @RequestMapping("/book")
    public BookVo bookvo(@RequestParam Long isbn) {
        return bookService.findBookVoByisbn(isbn);
    }
}

