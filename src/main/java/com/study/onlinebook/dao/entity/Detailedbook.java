package com.study.onlinebook.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Detailedbook implements Serializable {
    private Long isbn;

    private String publishinghouse;

    private Date publisheddate;

    private String format;

    private Integer nuberofpages;

    private BigDecimal readerrating;

    private Integer ranking;

    private String copyrightinformation;

    private Long barcode;

    private String binding;

    private Integer edition;

    private Integer numberofbooks;

    private BigDecimal weight;

    private Integer numberofprints;

    private String category;

    private static final long serialVersionUID = 1L;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getPublishinghouse() {
        return publishinghouse;
    }

    public void setPublishinghouse(String publishinghouse) {
        this.publishinghouse = publishinghouse == null ? null : publishinghouse.trim();
    }

    public Date getPublisheddate() {
        return publisheddate;
    }

    public void setPublisheddate(Date publisheddate) {
        this.publisheddate = publisheddate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public Integer getNuberofpages() {
        return nuberofpages;
    }

    public void setNuberofpages(Integer nuberofpages) {
        this.nuberofpages = nuberofpages;
    }

    public BigDecimal getReaderrating() {
        return readerrating;
    }

    public void setReaderrating(BigDecimal readerrating) {
        this.readerrating = readerrating;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getCopyrightinformation() {
        return copyrightinformation;
    }

    public void setCopyrightinformation(String copyrightinformation) {
        this.copyrightinformation = copyrightinformation == null ? null : copyrightinformation.trim();
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding == null ? null : binding.trim();
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getNumberofbooks() {
        return numberofbooks;
    }

    public void setNumberofbooks(Integer numberofbooks) {
        this.numberofbooks = numberofbooks;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getNumberofprints() {
        return numberofprints;
    }

    public void setNumberofprints(Integer numberofprints) {
        this.numberofprints = numberofprints;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", isbn=").append(isbn);
        sb.append(", publishinghouse=").append(publishinghouse);
        sb.append(", publisheddate=").append(publisheddate);
        sb.append(", format=").append(format);
        sb.append(", nuberofpages=").append(nuberofpages);
        sb.append(", readerrating=").append(readerrating);
        sb.append(", ranking=").append(ranking);
        sb.append(", copyrightinformation=").append(copyrightinformation);
        sb.append(", barcode=").append(barcode);
        sb.append(", binding=").append(binding);
        sb.append(", edition=").append(edition);
        sb.append(", numberofbooks=").append(numberofbooks);
        sb.append(", weight=").append(weight);
        sb.append(", numberofprints=").append(numberofprints);
        sb.append(", category=").append(category);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}