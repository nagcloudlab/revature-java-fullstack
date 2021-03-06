package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "todos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JacksonXmlRootElement
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private boolean completed;
    @Enumerated(EnumType.STRING)
    private TodoType type;
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

}
