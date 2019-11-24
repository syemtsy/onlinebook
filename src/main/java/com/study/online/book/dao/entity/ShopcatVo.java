package com.study.online.book.dao.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class ShopcatVo extends Shopcat implements Serializable {
    private Book book;
    private static final long serialVersionUID = 1L;

}
