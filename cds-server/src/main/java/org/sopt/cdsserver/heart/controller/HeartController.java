package org.sopt.cdsserver.heart.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.common.dto.ApiResponse;
import org.sopt.cdsserver.common.exception.enums.SuccessType;
import org.sopt.cdsserver.heart.controller.dto.response.HeartPutResponse;
import org.sopt.cdsserver.heart.service.HeartService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/heart")
@RequiredArgsConstructor
public class HeartController {

    private final HeartService heartService;


    @PutMapping("/{memberId}/{productId}")
    public ApiResponse<HeartPutResponse> toggleHeart(@PathVariable Long memberId, @PathVariable Long productId) {

        return ApiResponse.success(SuccessType.CATEGORY_SEARCH_SUCCESS, heartService.toggleHeart(memberId, productId));

    }


}

