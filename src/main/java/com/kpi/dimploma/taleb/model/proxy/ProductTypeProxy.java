package com.kpi.dimploma.taleb.model.proxy;

import com.kpi.dimploma.taleb.model.ProductCharacteristic;
import com.kpi.dimploma.taleb.model.ProductType;
import com.kpi.dimploma.taleb.persistence.ProductCharacteristicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class ProductTypeProxy extends ProductType {

    private boolean productCharacteristicsLoaded;

    private final ProductCharacteristicDao productCharacteristicDao;

    @Autowired
    public ProductTypeProxy(ProductCharacteristicDao productCharacteristicDao) {
        this.productCharacteristicDao = productCharacteristicDao;
    }

    @Override
    public List<ProductCharacteristic> getProductCharacteristics() {
        if (!productCharacteristicsLoaded) {
            this.setProductCharacteristics(productCharacteristicDao.findByProductTypeId(getProductTypeId()));
        }

        return super.getProductCharacteristics();
    }

    @Override
    public void setProductCharacteristics(List<ProductCharacteristic> productCharacteristics) {
        productCharacteristicsLoaded = true;
        super.setProductCharacteristics(productCharacteristics);
    }
}
