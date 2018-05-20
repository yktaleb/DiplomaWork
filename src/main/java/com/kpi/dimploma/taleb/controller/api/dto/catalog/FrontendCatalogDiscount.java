package com.kpi.dimploma.taleb.controller.api.dto.catalog;

import com.kpi.dimploma.taleb.model.Discount;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FrontendCatalogDiscount {
    private Long discountId;
    private String discountTitle;
    private double discount;

    public static FrontendCatalogDiscount fromEntity(Discount discount) {
        return FrontendCatalogDiscount.builder()
                .discountId(discount.getDiscountId())
                .discountTitle(discount.getDiscountTitle())
                .discount(discount.getDiscount())
                .build();
    }
}
