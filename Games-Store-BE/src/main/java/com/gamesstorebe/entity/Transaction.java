package com.gamesstorebe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateTrans;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
