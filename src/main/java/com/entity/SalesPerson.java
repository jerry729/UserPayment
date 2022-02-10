package com.entity;

public class SalesPerson {
    private Integer spid;

    private String spname;

    private String spsex;

    private String spage;

    private String spposition;

    private String uname;

    private String pwd;

    private String pubtime;

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname == null ? null : spname.trim();
    }

    public String getSpsex() {
        return spsex;
    }

    public void setSpsex(String spsex) {
        this.spsex = spsex == null ? null : spsex.trim();
    }

    public String getSpage() {
        return spage;
    }

    public void setSpage(String spage) {
        this.spage = spage == null ? null : spage.trim();
    }

    public String getSpposition() {
        return spposition;
    }

    public void setSpposition(String spposition) {
        this.spposition = spposition == null ? null : spposition.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
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
        sb.append(", spid=").append(spid);
        sb.append(", spname=").append(spname);
        sb.append(", spsex=").append(spsex);
        sb.append(", spage=").append(spage);
        sb.append(", spposition=").append(spposition);
        sb.append(", uname=").append(uname);
        sb.append(", pwd=").append(pwd);
        sb.append(", pubtime=").append(pubtime);
        sb.append("]");
        return sb.toString();
    }
}