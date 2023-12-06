package com.gamesstorebe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String image;
    private String video;
    private Double price;
    private String releaseDate  ;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "features_id")
    private Features feature;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developers developer;


}
