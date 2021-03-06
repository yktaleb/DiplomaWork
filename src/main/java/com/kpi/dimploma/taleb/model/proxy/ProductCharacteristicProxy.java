package com.kpi.dimploma.taleb.model.proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kpi.dimploma.taleb.model.Category;
import com.kpi.dimploma.taleb.model.ProductCharacteristic;
import com.kpi.dimploma.taleb.model.ProductType;
import com.kpi.dimploma.taleb.persistence.CategoryDao;
import com.kpi.dimploma.taleb.persistence.ProductTypeDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProductCharacteristicProxy extends ProductCharacteristic {
    @Getter @Setter
    private Long productTypeId;
    @Getter @Setter
    private Long dataTypeId;

    private boolean productTypeLoaded;
    private boolean dataTypeLoaded;

    private final ProductTypeDao productTypeDao;
    private final CategoryDao categoryDao;

    @Autowired
    public ProductCharacteristicProxy(ProductTypeDao productTypeDao, CategoryDao categoryDao) {
        this.productTypeDao = productTypeDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public ProductType getProductType() {
        if (!productTypeLoaded) {
            this.setProductType(productTypeDao.find(getProductTypeId()));
        }

        return super.getProductType();
    }

    @Override
    public void setProductType(ProductType productType) {
        productTypeLoaded = true;
        super.setProductType(productType);
    }

    @Override
    public Category getDataType() {
        if (!dataTypeLoaded) {
            this.setDataType(categoryDao.find(getDataTypeId()));
        }

        return super.getDataType();
    }

    @Override
    public void setDataType(Category dataType) {
        dataTypeLoaded = true;
        super.setDataType(dataType);
    }
}
