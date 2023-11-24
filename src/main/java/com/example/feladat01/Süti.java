package com.example.feladat01;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "suti")
public class Süti {
    @Id
    private int id;
    @Column(name = "nev")
    private String név;
    @Column(name = "tipus")
    private String típus;
    @Column(name = "dijazott")
    private boolean díjazott;

    @OneToMany
    @JoinColumn(name = "sutiid") // Az idegenkulcs az 'sutiid'-ra mutat
    private List<Ár> árak;

    @OneToOne
    @JoinColumn(name = "id") // Az idegenkulcs az 'sutiid'-ra mutat, mivel egy entitásra mutat
    private Tartalom tartalom;

    public List<Ár> getÁrak() {
        return árak;
    }

    public void setÁrak(List<Ár> árak) {
        this.árak = árak;
    }

    public Tartalom getTartalom() {
        return tartalom;
    }

    public void setTartalom(Tartalom tartalom) {
        this.tartalom = tartalom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNév() {
        return név;
    }

    public void setNév(String név) {
        this.név = név;
    }

    public String getTípus() {
        return típus;
    }

    public void setTípus(String típus) {
        this.típus = típus;
    }

    public boolean isDíjazott() {
        return díjazott;
    }

    public void setDíjazott(boolean díjazott) {
        this.díjazott = díjazott;
    }
}
