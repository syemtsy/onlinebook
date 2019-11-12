package com.study.onlinebook.dao.entity;

import java.io.Serializable;

public class Shippingaddress implements Serializable {
    private Integer id;

    private Long uid;

    private String addressinfo;

    private String address;

    private Integer postalcode;

    private String receiver;

    private Long tel;

    private Integer defult;

    private Integer addressid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(String addressinfo) {
        this.addressinfo = addressinfo == null ? null : addressinfo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Integer getDefult() {
        return defult;
    }

    public void setDefult(Integer defult) {
        this.defult = defult;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", addressinfo=").append(addressinfo);
        sb.append(", address=").append(address);
        sb.append(", postalcode=").append(postalcode);
        sb.append(", receiver=").append(receiver);
        sb.append(", tel=").append(tel);
        sb.append(", defult=").append(defult);
        sb.append(", addressid=").append(addressid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}