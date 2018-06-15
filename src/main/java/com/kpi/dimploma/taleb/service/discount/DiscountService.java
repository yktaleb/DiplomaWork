package com.kpi.dimploma.taleb.service.discount;

import com.kpi.dimploma.taleb.model.Discount;
import com.kpi.dimploma.taleb.model.ProductRegionPrice;
import com.kpi.dimploma.taleb.model.Region;
import com.kpi.dimploma.taleb.service.exceptions.DiscountException;

import java.util.Collection;

/**
 * Created by Taleb on 5/16/2018.
 */
public interface DiscountService {
    Collection<Discount> getDiscounts();

    Collection<Discount> getDiscountsPage(Long size, Long offset);

    Collection<Region> getRegions();

    Collection<ProductRegionPrice> getProductsRegionPricesForRegion(Long regionId);

    void add(Discount discount) throws DiscountException;

    void update(Discount discount) throws DiscountException;

    String getStatus();

    String getMessage();

    Long getAddedDiscountId();

    Discount findLargestDiscountByPriceId(Long priceId);
}
