package com.er.entity;

public class DaKaInfo {
    /*
    id int primary key auto_increment,
    eid int,
    qdtime datetime,
    qttime datetime
     */
    public int id;
    public int eid;//对象employee的id
    public String qdTime;
    public String qtTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getQdTime() {
        return qdTime;
    }

    public void setQdTime(String qdTime) {
        this.qdTime = qdTime;
    }

    public String getQtTime() {
        return qtTime;
    }

    public void setQtTime(String qtTime) {
        this.qtTime = qtTime;
    }

    @Override
    public String toString() {
        return "DaKaInfo{" +
                "id=" + id +
                ", eid=" + eid +
                ", qdTime='" + qdTime + '\'' +
                ", qtTime='" + qtTime + '\'' +
                '}';
    }
}
