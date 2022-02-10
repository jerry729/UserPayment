package com.entity;

public class Subject {
    private Integer id;

    private String name;

    private String pubtime;

    private Integer uid;

    private String status;

    private Integer znum;

    private Integer synum;

    private String btype;

    private String note;

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
        this.name = name == null ? null : name.trim();
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime == null ? null : pubtime.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getZnum() {
        return znum;
    }

    public void setZnum(Integer znum) {
        this.znum = znum;
    }

    public Integer getSynum() {
        return synum;
    }

    public void setSynum(Integer synum) {
        this.synum = synum;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype == null ? null : btype.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pubtime=").append(pubtime);
        sb.append(", uid=").append(uid);
        sb.append(", status=").append(status);
        sb.append(", znum=").append(znum);
        sb.append(", synum=").append(synum);
        sb.append(", btype=").append(btype);
        sb.append(", note=").append(note);
        sb.append("]");
        return sb.toString();
    }
}