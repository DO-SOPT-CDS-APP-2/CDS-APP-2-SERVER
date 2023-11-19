package org.sopt.cdsserver.product.controller.dto.response;

import org.sopt.cdsserver.product.domain.Product;

public record ProductDetailResponse(
        String imageUrl,
        String brand,
        String name,
        int price,
        int discountRate,
        int discountPrice,
        int point,
        int pointRate,
        String description
) {
    static double POINT_RATE_DEFAULT = 0.01;

    public static ProductDetailResponse of(final Product product) {
        return new ProductDetailResponse(
                product.getImageUrl(),
                product.getBrand().getName(),
                product.getTitle(),
                product.getPriceInfo().getPrice(),
                product.getPriceInfo().getDiscount(),
                product.getPriceInfo().getDiscountedPrice(),
                getPointAmount(product.getPriceInfo().getDiscountedPrice()),
                (int) (POINT_RATE_DEFAULT * 100),
                product.getDetails()
        );
    }

    private static int getPointAmount(final int price) {
        return (int) (price * POINT_RATE_DEFAULT);
    }
}
