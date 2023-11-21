package org.sopt.cdsserver.product.controller.dto.response;

import org.sopt.cdsserver.product.domain.Product;

public record ProductHomeListResponse(
        String imageUrl,
        String brand,
        String name,
        int discount,
        int price

) {
    public static ProductHomeListResponse of (Product product){
        return new ProductHomeListResponse(
                product.getImageUrl(),
                product.getBrand().getName(),
                product.getTitle(),
                product.getPriceInfo().getDiscount(),
                product.getPriceInfo().getPrice()
        );

    }
}
