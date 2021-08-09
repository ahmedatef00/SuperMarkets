package com.supermarket.supermarket.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "supermarkets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supermarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) //primitive type mandotry
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    @NotNull
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols")
    @Column(name = "ar_name")
    private String ar_name;
    @NotNull

    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols")
    @Column(name = "en_name")
    private String en_name;

    @NotNull
    @Size(min = 3, max = 30, message = "Name must be between 3 and 20 symbols")
    @Column(name = "address")
    private String address;


    @NotNull
    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "active")
    private boolean active;



}
