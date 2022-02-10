package com.entity;

public class Clients {
    private Integer clientid;

    private String cname;

    private String csex;

    private String ctele;

    private String clocation;

    private String pwd;

    private String uname;

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex == null ? null : csex.trim();
    }

    public String getCtele() {
        return ctele;
    }

    public void setCtele(String ctele) {
        this.ctele = ctele == null ? null : ctele.trim();
    }

    public String getClocation() {
        return clocation;
    }

    public void setClocation(String clocation) {
        this.clocation = clocation == null ? null : clocation.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clientid=").append(clientid);
        sb.append(", cname=").append(cname);
        sb.append(", csex=").append(csex);
        sb.append(", ctele=").append(ctele);
        sb.append(", clocation=").append(clocation);
        sb.append(", pwd=").append(pwd);
        sb.append(", uname=").append(uname);
        sb.append("]");
        return sb.toString();
    }
}