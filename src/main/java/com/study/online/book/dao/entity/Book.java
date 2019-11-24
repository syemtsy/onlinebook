package com.study.online.book.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Book implements Serializable {
    private Long id;

    private String bookname;

    private String author;

    private BigDecimal price;

    private String categorynumber;

    private Long isbn;

    private String img;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategorynumber() {
        return categorynumber;
    }

    public void setCategorynumber(String categorynumber) {
        this.categorynumber = categorynumber == null ? null : categorynumber.trim();
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookname=").append(bookname);
        sb.append(", author=").append(author);
        sb.append(", price=").append(price);
        sb.append(", categorynumber=").append(categorynumber);
        sb.append(", isbn=").append(isbn);
        sb.append(", img=").append(img);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
