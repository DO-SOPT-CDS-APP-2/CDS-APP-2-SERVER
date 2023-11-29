package org.sopt.cdsserver.heart.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.heart.controller.dto.response.HeartPutResponse;
import org.sopt.cdsserver.heart.domain.Heart;
import org.sopt.cdsserver.heart.repository.HeartRepository;
import org.sopt.cdsserver.member.domain.Member;
import org.sopt.cdsserver.member.service.MemberService;
import org.sopt.cdsserver.product.domain.Product;
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

    public HeartPutResponse toggleHeart(Long memberId, Long productId) {

        Optional<Heart> existingHeart = heartRepository.findByMemberIdAndProductId(memberId, productId);

        return existingHeart.map(heart -> {
            deleteHeart(heart);
            return HeartPutResponse.of(null);
        }).orElseGet(() -> {
            Heart newHeart = createHeart(memberId, productId);
            return HeartPutResponse.of(newHeart);
        });

    }

    private void deleteHeart(Heart heart) {
        heartRepository.delete(heart);

    }

    private Heart createHeart(Long memberId, Long productId) {
        Member member = memberService.getMemberById(memberId);
        Product product = productService.getProductById(productId);
        Heart newHeart = Heart.create(member, product);
        heartRepository.save(newHeart);
        return newHeart;
    }


}