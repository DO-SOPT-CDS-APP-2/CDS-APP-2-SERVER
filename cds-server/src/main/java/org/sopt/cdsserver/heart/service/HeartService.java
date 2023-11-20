package org.sopt.cdsserver.heart.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.heart.domain.Heart;
import org.sopt.cdsserver.heart.repository.HeartRepository;
import org.sopt.cdsserver.member.domain.Member;
import org.sopt.cdsserver.member.domain.repository.MemberJpaRepository;
import org.sopt.cdsserver.product.domain.Product;
import org.sopt.cdsserver.product.repository.ProductJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartService {
    private final HeartRepository heartRepository;
    private final MemberJpaRepository memberRepository;
    private final ProductJpaRepository productRepository;

    public String toggleHeart(Long memberId, Long productId) {

        Optional<Heart> existingHeart = heartRepository.findByMemberIdAndProductId(memberId, productId);

        if (existingHeart.isPresent()) {
            heartRepository.delete(existingHeart.get());
            return "Heart Deleted";
        } else {
            Member member = memberRepository.findById(memberId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Member ID"));
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Product ID"));

            Heart newHeart = Heart.create(member, product);
            heartRepository.save(newHeart);


            return "Heart Created";

        }

    }


}