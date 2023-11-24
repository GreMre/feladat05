package com.example.feladat01;
import jakarta.persistence.*;

@Entity
@Table(name = "ar")
public class Ár {
    @Id
    private int id;
    @Column(name = "sutiid", insertable = false, updatable = false)
    private int sutiid;
    @Column(name = "ertek")
    private int Érték;
    @Column(name = "egyseg")
    private String Egység;
    @ManyToOne
    @JoinColumn(name = "sutiid") // Az idegenkulcs az 'sutiid'-ra mutat
    private Süti süti;

    public Süti getSüti() {
        return süti;
    }

    public void setSüti(Süti süti) {
        this.süti = süti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSutiid() {
        return sutiid;
    }

    public void setSutiid(int sutiid) {
        this.sutiid = sutiid;
    }

    public int getÉrték() {
        return Érték;
    }

    public void setÉrték(int érték) {
        Érték = érték;
    }

    public String getEgység() {
        return Egység;
    }

    public void setEgység(String egység) {
        Egység = egység;
    }
}

