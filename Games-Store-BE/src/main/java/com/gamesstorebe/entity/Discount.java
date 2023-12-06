package com.gamesstorebe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double percentDiscount;
    private Date startDate;
    private Date endDate;
    private Boolean status;

}
