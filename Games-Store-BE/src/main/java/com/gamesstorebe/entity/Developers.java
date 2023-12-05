package com.gamesstorebe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
public class Developers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  developerName;

    @OneToMany(mappedBy = "developer")
    private Set<Product> products = new HashSet<>();

}
