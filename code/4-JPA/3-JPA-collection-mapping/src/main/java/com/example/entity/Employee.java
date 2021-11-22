package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    public int id;
    public String name;

    @ElementCollection
    @CollectionTable(
            name = "emp_addresses",
            foreignKey = @ForeignKey(name="id"))
    public List<Address> addresses;


}
