package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "quantity")
    private  int quantity;

    @Column(name = "describe", length = 100)
    private String describe;
}
