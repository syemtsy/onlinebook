package com.study.online.book.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrdersVoVo extends Orders implements  Serializable {
    private List<Book> books;
    private List<Ordersinfo> ordersinfos;
}
