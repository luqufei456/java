package com.yiran.reverse.pojo;

public class Item {
    private Integer itemid;

    private String itemname;

    private Double itemprice;

    private String iteminfo;

    @Override
    public String toString() {
        return "Item{" +
                "itemid=" + itemid +
                ", itemname='" + itemname + '\'' +
                ", itemprice=" + itemprice +
                ", iteminfo='" + iteminfo + '\'' +
                '}';
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public Double getItemprice() {
        return itemprice;
    }

    public void setItemprice(Double itemprice) {
        this.itemprice = itemprice;
    }

    public String getIteminfo() {
        return iteminfo;
    }

    public void setIteminfo(String iteminfo) {
        this.iteminfo = iteminfo == null ? null : iteminfo.trim();
    }
}