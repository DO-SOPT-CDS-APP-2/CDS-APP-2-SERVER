package org.sopt.cdsserver.product.service;


import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.category.domain.Category;
import org.sopt.cdsserver.common.exception.enums.ErrorType;
import org.sopt.cdsserver.common.exception.model.NotFoundException;
import org.sopt.cdsserver.product.controller.dto.response.ProductDetailResponse;
import org.sopt.cdsserver.product.controller.dto.response.ProductListResponse;
import org.sopt.cdsserver.product.domain.Product;
import org.sopt.cdsserver.product.repository.ProductJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductJpaRepository productJpaRepository;
    public Product getProductById(final Long productId){
        return productJpaRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(ErrorType.PRODUCT_NOT_FOUND_EXCEPTION));
    }

    public List<ProductListResponse> getProductListByCategory(final Category category) {
        List<Product> productList = productJpaRepository.findAllByCategory(category);
        if (isProductListEmpty(productList)) {
            throw new NotFoundException(ErrorType.PRODUCT_NOT_IN_CATEGORY_EXCEPTION);
        }
        return productList.stream()
                .map(ProductListResponse::of)
                .collect(Collectors.toList());
    }

    private boolean isProductListEmpty(final List<Product> productList) {
        if (productList.isEmpty()) {
            return true;
        }
        return false;
    }

    public ProductDetailResponse getProductDetails(final Long productId) {
        Product product = productJpaRepository.findById(productId).orElseThrow(
                () -> new NotFoundException(ErrorType.PRODUCT_NOT_FOUND_EXCEPTION)
        );
        return ProductDetailResponse.of(product);
    }
}
