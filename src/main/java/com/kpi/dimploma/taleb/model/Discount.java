package com.kpi.dimploma.taleb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;


/**
 * Created by Taleb on 4/24/2018.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    private Long discountId;
    private String discountTitle;
    private double discount;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

    private List<ProductRegionPrice> productRegionPrices;
}
