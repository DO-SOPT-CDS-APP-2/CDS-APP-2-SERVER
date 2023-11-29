package org.sopt.cdsserver.category.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.category.domain.Category;
import org.sopt.cdsserver.common.exception.enums.ErrorType;
import org.sopt.cdsserver.common.exception.model.NotFoundException;
import org.sopt.cdsserver.product.controller.dto.response.ProductHomeListResponse;
import org.sopt.cdsserver.product.controller.dto.response.ProductListResponse;
import org.sopt.cdsserver.category.repository.CategoryJpaRepository;
import org.sopt.cdsserver.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryJpaRepository categoryJpaRepository;
    private final ProductService productService;

    public List<ProductListResponse> getCategoryList(final int categoryId) {
        Category category = categoryJpaRepository.findById(categoryId).orElseThrow(
                () -> new NotFoundException(ErrorType.CATEGORY_NOT_FOUND_EXCEPTION)
        );
        return productService.getProductListByCategory(category);
    }

    public List<ProductHomeListResponse> getHomeCategoryList(final int categoryId){
        Category category = categoryJpaRepository.findById(categoryId).orElseThrow(
                () -> new NotFoundException(ErrorType.CATEGORY_NOT_FOUND_EXCEPTION)
        );
        return productService.getProductHomeListByCategory(category);
    }
}
