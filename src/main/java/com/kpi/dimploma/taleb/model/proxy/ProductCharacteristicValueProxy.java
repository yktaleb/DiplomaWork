package com.kpi.dimploma.taleb.model.proxy;

import com.kpi.dimploma.taleb.model.Product;
import com.kpi.dimploma.taleb.model.ProductCharacteristic;
import com.kpi.dimploma.taleb.model.ProductCharacteristicValue;
import com.kpi.dimploma.taleb.persistence.ProductCharacteristicDao;
import com.kpi.dimploma.taleb.persistence.ProductDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProductCharacteristicValueProxy extends ProductCharacteristicValue {

    private ProductDao productDao;
    private ProductCharacteristicDao productCharacteristicDao;

    @Getter @Setter
    private Long productId;
    @Getter @Setter
    private Long productCharacteristicId;

    private boolean productLoaded;
    private boolean productCharacteristicLoaded;

    @Autowired
    public ProductCharacteristicValueProxy(ProductCharacteristicDao productCharacteristicDao, ProductDao productDao) {
        this.productCharacteristicDao = productCharacteristicDao;
        this.productDao = productDao;
    }

    @Override
    public Product getProduct() {
        if (!productLoaded) {
            this.setProduct(productDao.find(getProductId()));
        }
        return super.getProduct();
    }

    @Override
    public void setProduct(Product product) {
        productLoaded = true;
        super.setProduct(product);
    }

    @Override
    public ProductCharacteristic getProductCharacteristic() {
        if (!productCharacteristicLoaded) {
            this.setProductCharacteristic(productCharacteristicDao.find(getProductCharacteristicId()));
        }
        return super.getProductCharacteristic();
    }

    @Override
    public void setProductCharacteristic(ProductCharacteristic productCharacteristic) {
        productCharacteristicLoaded = true;
        super.setProductCharacteristic(productCharacteristic);
    }
}
