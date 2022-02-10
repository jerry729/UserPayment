package com.entity;

public class Contracts {
    private Integer ctrctid;

    private String ctrctname;

    private Integer clientid;

    private Integer spid;

    private String signedt;

    private String expiret;

    private Integer comid;

    private Integer comquant;

    private Double amount;

    private String status;

    private String pubtime;

    public Integer getCtrctid() {
        return ctrctid;
    }

    public void setCtrctid(Integer ctrctid) {
        this.ctrctid = ctrctid;
    }

    public String getCtrctname() {
        return ctrctname;
    }

    public void setCtrctname(String ctrctname) {
        this.ctrctname = ctrctname == null ? null : ctrctname.trim();
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getSignedt() {
        return signedt;
    }

    public void setSignedt(String signedt) {
        this.signedt = signedt == null ? null : signedt.trim();
    }

    public String getExpiret() {
        return expiret;
    }

    public void setExpiret(String expiret) {
        this.expiret = expiret == null ? null : expiret.trim();
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getComquant() {
        return comquant;
    }

    public void setComquant(Integer comquant) {
        this.comquant = comquant;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ctrctid=").append(ctrctid);
        sb.append(", ctrctname=").append(ctrctname);
        sb.append(", clientid=").append(clientid);
        sb.append(", spid=").append(spid);
        sb.append(", signedt=").append(signedt);
        sb.append(", expiret=").append(expiret);
        sb.append(", comid=").append(comid);
        sb.append(", comquant=").append(comquant);
        sb.append(", amount=").append(amount);
        sb.append(", status=").append(status);
        sb.append(", pubtime=").append(pubtime);
        sb.append("]");
        return sb.toString();
    }
}