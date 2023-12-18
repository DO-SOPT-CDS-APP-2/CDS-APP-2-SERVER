package org.sopt.cdsserver.heart.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.common.exception.enums.ErrorType;
import org.sopt.cdsserver.common.exception.model.NotFoundException;
import org.sopt.cdsserver.heart.controller.dto.response.HeartPutResponse;
import org.sopt.cdsserver.heart.domain.Heart;
import org.sopt.cdsserver.heart.repository.HeartRepository;
import org.sopt.cdsserver.member.domain.Member;
import org.sopt.cdsserver.member.service.MemberService;
import org.sopt.cdsserver.product.domain.Product;
import org.sopt.cdsserver.product.service.ProductService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartService {
    private final HeartRepository heartRepository;
    private final MemberService memberService;
    private final ProductService productService;

    public HeartPutResponse toggleHeart(Long memberId, Long productId) {
        try {
            Heart newHeart = createHeart(memberId, productId);
            return HeartPutResponse.of(newHeart);
        } catch (DataIntegrityViolationException e)  {
            deleteHeart(memberId, productId);
            return HeartPutResponse.of(null);
        }
    }

    public void deleteHeart(Long memberId, Long productId) {
        Heart heart = heartRepository.findByMemberIdAndProductId(memberId, productId).orElseThrow(
                () -> new NotFoundException(ErrorType.HEART_NOT_FOUND_EXCEPTION)
        );
        heartRepository.delete(heart);
    }

    private Heart createHeart(Long memberId, Long productId) {
        Member member = memberService.getMemberById(memberId);
        Product product = productService.getProductById(productId);
        Heart newHeart = Heart.create(member, product);
        heartRepository.saveAndFlush(newHeart);
        return newHeart;
    }

    public HeartPutResponse create(Long memberId, Long productId) {
        return HeartPutResponse.of(createHeart(memberId, productId));
    }
}