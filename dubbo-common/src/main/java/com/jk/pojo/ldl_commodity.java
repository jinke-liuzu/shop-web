package com.jk.pojo;

import java.io.Serializable;

public class ldl_commodity implements Serializable {
    private static final long serialVersionUID = -2967028756210332937L;
    private Integer id;
    private Integer number;
    private String name;
    private String datetime;
    private Integer state;
    private String goodsname;
    private Integer money;
    private String url;
    private Integer current;
    private Integer quantity;

    @Override
    public String toString() {
        return "ldl_commodity{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", datetime='" + datetime + '\'' +
                ", state=" + state +
                ", goodsname='" + goodsname + '\'' +
                ", money=" + money +
                ", url='" + url + '\'' +
                ", current=" + current +
                ", quantity=" + quantity +
                '}';
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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
}
