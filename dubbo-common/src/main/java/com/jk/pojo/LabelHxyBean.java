package com.jk.pojo;

import java.io.Serializable;

public class LabelHxyBean implements Serializable {
    private static final long serialVersionUID = 4620042582406534367L;
    private Integer id;
    private String name;
    private Integer sort;
    private String createTime;
    private String img;
    private Integer page;
    private Integer rows;
    private String remark;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LabelHxyBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", createTime='" + createTime + '\'' +
                ", img='" + img + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                ", remark='" + remark + '\'' +
                '}';
    }
}
