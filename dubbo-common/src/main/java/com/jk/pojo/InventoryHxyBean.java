package com.jk.pojo;


import java.io.Serializable;

public class InventoryHxyBean implements  Serializable{

    private static final long serialVersionUID = 8674531446172093630L;
    private Integer id;
    private String number;
    private String commodity;
    private String type;
    private Integer quantity;
    private Integer delivery;
    private Integer current;
    private String remark;
    private String createTimes;
    private Integer page;
    private Integer rows;
    private Integer money;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTimes() {
        return createTimes;
    }

    public void setCreateTimes(String createTimes) {
        this.createTimes = createTimes;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "InventoryHxyBean{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", commodity='" + commodity + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", delivery=" + delivery +
                ", current=" + current +
                ", remark='" + remark + '\'' +
                ", createTimes='" + createTimes + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                ", money=" + money +
                '}';
    }
}
