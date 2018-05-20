package com.kpi.dimploma.taleb.controller.api.dto;

import com.kpi.dimploma.taleb.model.Product;
import com.kpi.dimploma.taleb.model.ProductRegionPrice;
import com.kpi.dimploma.taleb.model.Region;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FrontendPrice {
    private Long priceId;
    private Long regionId;
    private double price;

    public static FrontendPrice fromEntity(ProductRegionPrice price) {
        return FrontendPrice.builder()
                .priceId(price.getPriceId())
                .regionId(price.getRegion().getRegionId())
                .price(price.getPrice())
                .build();
    }

    public ProductRegionPrice toModel(Long productId) {
        return ProductRegionPrice.builder()
                .priceId(getPriceId())
                .product(new Product(productId))
                .region(new Region(getRegionId()))
                .price(getPrice())
                .build();
    }
}
