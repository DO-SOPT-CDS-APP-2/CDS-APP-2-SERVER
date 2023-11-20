package org.sopt.cdsserver.heart.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.cdsserver.member.domain.Member;
import org.sopt.cdsserver.product.domain.Product;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;

    @Builder
    public Heart(Member member, Product product){
        this.member = member;
        this.product = product;
    }


}