package com.example.entity;

import javax.persistence.*;

@Embeddable
public class Address {
    @Column(name="addr_type")
    @Enumerated(EnumType.STRING)
    public AddressType addrType;
    public String city;
    public String country;
}
