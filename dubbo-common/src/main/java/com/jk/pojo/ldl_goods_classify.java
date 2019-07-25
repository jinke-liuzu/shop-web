package com.jk.pojo;

import java.io.Serializable;
import java.util.List;

public class ldl_goods_classify implements Serializable {
    private static final long serialVersionUID = -8606162121852497855L;
    private Integer id;
    private String text;
    private Integer order;
    private Integer generalstore;
    private String ownstores;
    private Integer pid;
    private String url;
    private String examine;

    private List<ldl_goods_classify> nodes;
    private Boolean selectable;//标识节点能不能点击

    public List<ldl_goods_classify> getNodes() {
        return nodes;
    }

    public void setNodes(List<ldl_goods_classify> nodes) {
        this.nodes = nodes;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getGeneralstore() {
        return generalstore;
    }

    public void setGeneralstore(Integer generalstore) {
        this.generalstore = generalstore;
    }

    public String getOwnstores() {
        return ownstores;
    }

    public void setOwnstores(String ownstores) {
        this.ownstores = ownstores;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExamine() {
        return examine;
    }

    public void setExamine(String examine) {
        this.examine = examine;
    }

    @Override
    public String toString() {
        return "ldl_goods_classify{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", order=" + order +
                ", generalstore=" + generalstore +
                ", ownstores='" + ownstores + '\'' +
                ", pid=" + pid +
                ", url='" + url + '\'' +
                ", examine='" + examine + '\'' +
                ", nodes=" + nodes +
                ", selectable=" + selectable +
                '}';
    }
}
