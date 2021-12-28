package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false, referencedColumnName = "cart_id")
    private Cart cart;
}
