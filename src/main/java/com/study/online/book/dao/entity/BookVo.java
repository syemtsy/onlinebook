package com.study.online.book.dao.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookVo extends Book implements Serializable {
    private Detailedbook detailedbook;
    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return super.toString()+ "BookVo{" +
                "detailedbook=" + detailedbook +
                '}';
    }


}
