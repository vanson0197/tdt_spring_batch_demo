package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name= "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address", length = 50)
    private String address;

}
