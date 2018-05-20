package com.kpi.dimploma.taleb.controller.api.dto;

import com.kpi.dimploma.taleb.model.Product;
import com.kpi.dimploma.taleb.model.ProductCharacteristic;
import com.kpi.dimploma.taleb.model.ProductCharacteristicValue;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class FrontendCharacteristicValue {
    private Long valueId;
    private Long productCharacteristicId;
    private Number numberValue;
    private OffsetDateTime dateValue;
    private String stringValue;

    public static FrontendCharacteristicValue fromEntity(ProductCharacteristicValue value) {
        return FrontendCharacteristicValue.builder()
                .valueId(value.getValueId())
                .productCharacteristicId(value.getProductCharacteristic().getProductCharacteristicId())
                .dateValue(value.getDateValue())
                .stringValue(value.getStringValue())
                .numberValue(value.getNumberValue())
                .build();
    }

    public ProductCharacteristicValue toModel(Long productId) {
        return ProductCharacteristicValue.builder()
                .valueId(getValueId())
                .product(new Product(productId))
                .productCharacteristic(new ProductCharacteristic(getProductCharacteristicId()))
                .numberValue(getNumberValue())
                .dateValue(getDateValue())
                .stringValue(getStringValue())
                .build();
    }
}
