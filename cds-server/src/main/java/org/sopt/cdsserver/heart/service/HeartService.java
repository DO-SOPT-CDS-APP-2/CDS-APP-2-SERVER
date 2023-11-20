package org.sopt.cdsserver.heart.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.heart.domain.Heart;
import org.sopt.cdsserver.heart.repository.HeartRepository;
import org.sopt.cdsserver.member.domain.Member;
import org.sopt.cdsserver.member.repository.MemberJpaRepository;
import org.sopt.cdsserver.member.service.MemberService;
import org.sopt.cdsserver.product.domain.Product;
import org.sopt.cdsserver.product.repository.ProductJpaRepository;
import org.sopt.cdsserver.product.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartService {
    private final HeartRepository heartRepository;
    private final MemberService memberService;
    private final ProductService productService;

    public boolean toggleHeart(Long memberId, Long productId) {

        Optional<Heart> existingHeart = heartRepository.findByMemberIdAndProductId(memberId, productId);

        return existingHeart.map(heart -> {
            heartRepository.delete(heart);
            return false;
        }).orElseGet(() -> {
            Member member = memberService.getMemberById(memberId);
            Product product = productService.getProductById(productId);
            Heart newHeart = Heart.create(member, product);
            heartRepository.save(newHeart);
            return true;
        });
//        if (existingHeart.isPresent()) {
//            heartRepository.delete(existingHeart.get());
//            return false;
//        } else {
//            Member member = memberService.getMemberById(memberId);
//
//            Product product = productService.getProductById(productId);
//
//            Heart newHeart = Heart.create(member, product);
//            heartRepository.save(newHeart);
//
//
//            return true;

//        }
//
   }


}