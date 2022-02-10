package com.entity;

public class Record {
    private Integer rid;

    private Integer spid;

    private Integer clientid;

    private Integer ctrctid;

    private String rcrdt;

    private Double rcrdquant;

    private Integer billid;

    private String status;

    private String pubtime;

    private String mark;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public String getRcrdt() {
        return rcrdt;
    }

    public void setRcrdt(String rcrdt) {
        this.rcrdt = rcrdt == null ? null : rcrdt.trim();
    }

    public Double getRcrdquant() {
        return rcrdquant;
    }

    public void setRcrdquant(Double rcrdquant) {
        this.rcrdquant = rcrdquant;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime == null ? null : pubtime.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", spid=").append(spid);
        sb.append(", clientid=").append(clientid);
        sb.append(", ctrctid=").append(ctrctid);
        sb.append(", rcrdt=").append(rcrdt);
        sb.append(", rcrdquant=").append(rcrdquant);
        sb.append(", billid=").append(billid);
        sb.append(", status=").append(status);
        sb.append(", pubtime=").append(pubtime);
        sb.append(", mark=").append(mark);
        sb.append("]");
        return sb.toString();
    }
}