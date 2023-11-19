package org.sopt.cdsserver.product.controller.dto.response;

import org.sopt.cdsserver.product.domain.Product;

public record ProductListResponse(
        int productId,
        String imageUrl,
        String brand,
        String name,
        int discount,
        int price
) {
    public static ProductListResponse of(final Product product) {
        return new ProductListResponse(
                product.getId().intValue(),
                product.getImageUrl(),
                product.getBrand().getName(),
                product.getTitle(),
                product.getPriceInfo().getDiscount(),
                product.getPriceInfo().getDiscountedPrice()
        );
    }
}
