package com.entity;

public class Commodity {
    private Integer comid;

    private String comname;

    private Double unitprice;

    private Integer reserve;

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname == null ? null : comname.trim();
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", comid=").append(comid);
        sb.append(", comname=").append(comname);
        sb.append(", unitprice=").append(unitprice);
        sb.append(", reserve=").append(reserve);
        sb.append("]");
        return sb.toString();
    }
}