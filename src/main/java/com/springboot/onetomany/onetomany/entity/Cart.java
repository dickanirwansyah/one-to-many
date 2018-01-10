package com.springboot.onetomany.onetomany.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "cart",
catalog = "belajar")
public class Cart implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcart;

    @Column(name = "tanggal", nullable = false)
    private Date tanggal;

    @Column(name = "customer" ,nullable = false)
    private String customer;

    @OneToMany(mappedBy = "cart")
    private Set<Items> itemsSet = new HashSet<Items>();
}
