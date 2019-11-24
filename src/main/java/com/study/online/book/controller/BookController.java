package com.study.online.book.controller;

import com.study.online.book.common.api.CommonResult;
import com.study.online.book.service.BookService;
import com.study.online.book.dao.entity.Book;
import com.study.online.book.dao.entity.BookVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * 书籍管理Controller
 * @Created by symet on 21:53 2019/11/24
 **/
@Api(tags = "BookController",description = "书籍管理")
@Controller
public class BookController {
    @Autowired
    private BookService bookService;



    @ApiOperation("分页查询书籍列表")
    @ResponseBody
    @RequestMapping(value = "/booklist",method = RequestMethod.GET)
    public CommonResult<List<Book>> bookPage(@ApiParam("第几页") @RequestParam Integer pageble_number,
                               @ApiParam("要搜索的字符串") @RequestParam String string,
                               @ApiParam("搜索的类型;0为全部1为书名2为作者")@RequestParam int select) {
       return CommonResult.success(bookService.findAllBynameOrauthor("%" + string + "%", select, pageble_number));

    }

    @ApiOperation("根据isbn查询书籍信息")
    @ResponseBody
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public CommonResult<BookVo> bookvo(@ApiParam("书籍编号")@RequestParam Long isbn) {
        return CommonResult.success(bookService.findBookVoByisbn(isbn));
    }
}

