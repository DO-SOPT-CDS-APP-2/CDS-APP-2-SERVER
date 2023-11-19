package org.sopt.cdsserver.product.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.common.dto.ApiResponse;
import org.sopt.cdsserver.common.exception.enums.SuccessType;
import org.sopt.cdsserver.product.controller.dto.response.ProductDetailResponse;
import org.sopt.cdsserver.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ApiResponse<ProductDetailResponse> getProductDetails(@PathVariable final Long productId) {
        return ApiResponse.success(SuccessType.PRODUCT_SEARCH_SUCCESS, productService.getProductDetails(productId));
    }
}
