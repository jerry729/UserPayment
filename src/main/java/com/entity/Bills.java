package com.entity;

public class Bills {
    private Integer billid;

    private Integer spid;

    private Integer clientid;

    private Integer ctrctid;

    private Double arrear;

    private Integer repayt;

    private String pubtime;

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getCtrctid() {
        return ctrctid;
    }

    public void setCtrctid(Integer ctrctid) {
        this.ctrctid = ctrctid;
    }

    public Double getArrear() {
        return arrear;
    }

    public void setArrear(Double arrear) {
        this.arrear = arrear;
    }

    public Integer getRepayt() {
        return repayt;
    }

    public void setRepayt(Integer repayt) {
        this.repayt = repayt;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime == null ? null : pubtime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billid=").append(billid);
        sb.append(", spid=").append(spid);
        sb.append(", clientid=").append(clientid);
        sb.append(", ctrctid=").append(ctrctid);
        sb.append(", arrear=").append(arrear);
        sb.append(", repayt=").append(repayt);
        sb.append(", pubtime=").append(pubtime);
        sb.append("]");
        return sb.toString();
    }
}