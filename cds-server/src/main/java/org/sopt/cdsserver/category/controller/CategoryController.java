package org.sopt.cdsserver.category.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.cdsserver.product.controller.dto.response.ProductListResponse;
import org.sopt.cdsserver.category.service.CategoryService;
import org.sopt.cdsserver.common.dto.ApiResponse;
import org.sopt.cdsserver.common.exception.enums.SuccessType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{categoryId}")
    public ApiResponse<List<ProductListResponse>> getCategoryList(@PathVariable final int categoryId) {
        return ApiResponse.success(
                SuccessType.CATEGORY_SEARCH_SUCCESS,
                categoryService.getCategoryList(categoryId)
                );
    }

}
