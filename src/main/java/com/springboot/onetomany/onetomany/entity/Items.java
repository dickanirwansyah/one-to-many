package com.springboot.onetomany.onetomany.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name = "items",
        catalog = "belajar")
public class Items implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iditems;

    @ManyToOne
    @JoinColumn(name = "idcart", nullable = false)
    private Cart cart;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unitprice", nullable = false)
    private int unitprice;

    public Items(){}

    public Items(Cart cart, String name, int quantity, int unitprice){
        this.cart=cart;
        this.name=name;
        this.quantity=quantity;
        this.unitprice=unitprice;
    }
}
