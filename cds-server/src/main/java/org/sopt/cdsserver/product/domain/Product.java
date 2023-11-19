package org.sopt.cdsserver.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.sopt.cdsserver.category.domain.Category;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Brand brand; //enum

    private int price;

    private int discount;

    private String details;

    @ManyToOne
    private Category category;
}
