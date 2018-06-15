package com.kpi.dimploma.taleb.controller.api.dto;

import com.kpi.dimploma.taleb.model.Discount;
import com.kpi.dimploma.taleb.model.ProductRegionPrice;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Taleb on 5/16/2018.
 */
@Data
@Builder
public class FrontendDiscount {
    private Long discountId;
    private String discountTitle;
    private Double discount;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private List<FrontEndProductRegionPrice> productRegionPrices;


    public static FrontendDiscount fromEntity(Discount discount){
        return builder().discountId(discount.getDiscountId())
                .discountTitle(discount.getDiscountTitle())
                .discount(discount.getDiscount())
                .startDate(discount.getStartDate())
                .endDate(discount.getEndDate())
                .productRegionPrices(discount.getProductRegionPrices().stream()
                        .map(FrontEndProductRegionPrice::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Discount toEntity(FrontendDiscount frontendDiscount){

        return Discount.builder().discountId(frontendDiscount.getDiscountId())
                .discountTitle(frontendDiscount.getDiscountTitle()).discount(frontendDiscount.getDiscount())
                .startDate(frontendDiscount.getStartDate())
                .endDate(frontendDiscount.getEndDate())
                .productRegionPrices(frontendDiscount.getProductRegionPrices().stream()
                        .map(FrontEndProductRegionPrice::toEntity)
                        .collect(Collectors.toList()))
                .build();

    }
}
