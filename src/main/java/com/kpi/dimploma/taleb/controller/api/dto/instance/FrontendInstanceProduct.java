package com.kpi.dimploma.taleb.controller.api.dto.instance;

import com.kpi.dimploma.taleb.controller.api.dto.FrontendCharacteristicValue;
import com.kpi.dimploma.taleb.controller.api.dto.FrontendPrice;
import com.kpi.dimploma.taleb.controller.api.dto.FrontendProductType;
import com.kpi.dimploma.taleb.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FrontendInstanceProduct {
    private Long productId;
    private String productName;
    private String productDescription;
    private Boolean isActive;
    private FrontendProductType productType;

    private List<FrontendCharacteristicValue> productCharacteristicValues;
    private List<FrontendPrice> prices;

    public static FrontendInstanceProduct fromEntity(Product product) {
        return FrontendInstanceProduct.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .isActive(product.getIsActive())
                .productType(FrontendProductType.fromEntity(product.getProductType()))
                .productCharacteristicValues(product.getProductCharacteristicValues()
                        .stream()
                        .map(FrontendCharacteristicValue::fromEntity)
                        .collect(Collectors.toList()))
                .prices(product.getPrices()
                        .stream()
                        .map(FrontendPrice::fromEntity)
                        .collect(Collectors.toList()))
                .build();

    }
}
