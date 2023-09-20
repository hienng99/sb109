package com.nvhien.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "oder_line_items", indexes = {@Index(columnList = "sku_code", unique = true)})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;
}
