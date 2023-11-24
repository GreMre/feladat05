package com.example.feladat01;

import jakarta.persistence.*;

@Entity
@Table(name = "tartalom")
public class Tartalom {
    @Id
    private int id;
    @Column(name = "sutiid", insertable = false, updatable = false)
    private int sutiid;
    @Column(name = "mentes")
    private String mentes;




    public int getSutiid() {
        return sutiid;
    }

    public void setSutiid(int sutiid) {
        this.sutiid = sutiid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMentes() {
        return mentes;
    }

    public void setMentes(String mentes) {
        this.mentes = mentes;
    }
}