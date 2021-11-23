package com.example.entity;

import javax.persistence.*;

@Entity
public class Boy {
    @Id
    public int id;
    public String name;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "G_ID")
    public Girl girl;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Girl getGirl() {
        return girl;
    }

}
