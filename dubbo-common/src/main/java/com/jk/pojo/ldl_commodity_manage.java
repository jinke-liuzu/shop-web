package com.jk.pojo;

import java.io.Serializable;

public class ldl_commodity_manage implements Serializable {
    private static final long serialVersionUID = 1928216893369345736L;
    private Integer id;
    private Integer number;
    private String name;
    private String datetime;
    private String startTime;
    private String endTime;
    private Integer state;
    private Integer goodsid;
    private String goodsname;
    private Integer money;
    private String url;
    private Integer current;
    private Integer quantity;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ldl_commodity_manage{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", datetime='" + datetime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", state=" + state +
                ", goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", money=" + money +
                ", url='" + url + '\'' +
                ", current=" + current +
                ", quantity=" + quantity +
                '}';
    }
}
