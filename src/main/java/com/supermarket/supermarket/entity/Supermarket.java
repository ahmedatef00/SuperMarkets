package com.supermarket.supermarket.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supermarkets")
@Data
public class Supermarket {
    @Id
    private Long id;
    @Column(name = "ar_name")
    private String ar_name;
    @Column(name = "en_name")
    private String en_name;
    @Column(name = "address")
    private String address;
    @Column(name = "image")
    private String image;
}
