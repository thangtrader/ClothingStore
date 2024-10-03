package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data //toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "number_of_product", nullable = false)
    private int numberOfProduct;

    @Column(name = "total_money", nullable = false)
    private Float totalMoney;

    @Column(name = "color")
    private String color;
}
