package org.sopt.cdsserver.like.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.sopt.cdsserver.member.domain.Member;
import org.sopt.cdsserver.product.domain.Product;

@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Member memberId;

    @OneToOne
    private Product productId;

}
