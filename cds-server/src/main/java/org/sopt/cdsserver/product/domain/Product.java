package org.sopt.cdsserver.product.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.sopt.cdsserver.category.domain.Category;

@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imageUrl;


    @Enumerated(value = EnumType.STRING)
    private Brand brand; //enum

    @Embedded
    private PriceInfo priceInfo;

    private String details;

    @ManyToOne
    private Category category;
}
