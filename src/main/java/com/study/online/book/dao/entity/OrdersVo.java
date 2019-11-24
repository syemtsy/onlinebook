package com.study.online.book.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class OrdersVo extends Orders implements Serializable {

    List<Ordersinfo> ordersinfolist;
    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return "[OrdersVo" + super.toString() + "ordersinfolist=" + ordersinfolist+
                "]";
    }
}
