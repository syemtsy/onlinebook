package com.study.onlinebook.dao.entity;

import java.io.Serializable;

public class Ordersinfo implements Serializable {
    private Long id;

    private Long orderinfoid;

    private Long isbn;

    private Integer number;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderinfoid() {
        return orderinfoid;
    }

    public void setOrderinfoid(Long orderinfoid) {
        this.orderinfoid = orderinfoid;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderinfoid=").append(orderinfoid);
        sb.append(", isbn=").append(isbn);
        sb.append(", number=").append(number);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}