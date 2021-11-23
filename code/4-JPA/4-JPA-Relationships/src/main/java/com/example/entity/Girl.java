package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Girl {
    @Id
    public int id;
    public String name;
    @OneToOne(mappedBy = "girl",targetEntity = Boy.class)
    public Boy boy;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boy getBoy() {
        return boy;
    }
}
