package com.example.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name="author_name")
    private String authorName;
    private double price;
    private String description;
    @Transient
    private int publisherId;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;



}

// ORM ( Object Relational Mapping )