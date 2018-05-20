package com.kpi.dimploma.taleb.model.proxy;

import com.kpi.dimploma.taleb.model.Discount;
import com.kpi.dimploma.taleb.model.ProductRegionPrice;
import com.kpi.dimploma.taleb.persistence.ProductRegionPriceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class DiscountProxy extends Discount {

    private final ProductRegionPriceDao productRegionPriceDao;

    private boolean productRegionPricesLoaded;

    @Autowired
    public DiscountProxy(ProductRegionPriceDao productRegionPriceDao) {
        this.productRegionPriceDao = productRegionPriceDao;
    }

    @Override
    public List<ProductRegionPrice> getProductRegionPrices() {
        if(!productRegionPricesLoaded){
            this.setProductRegionPrices(productRegionPriceDao.findByDiscountId(getDiscountId()));
        }

        return super.getProductRegionPrices();
    }

    @Override
    public void setProductRegionPrices(List<ProductRegionPrice> productRegionPrices) {
        productRegionPricesLoaded = true;
        super.setProductRegionPrices(productRegionPrices);
    }
}
