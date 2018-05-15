package com.grad.project.nc.service.discount;

import com.grad.project.nc.model.Discount;
import com.grad.project.nc.model.ProductRegionPrice;
import com.grad.project.nc.model.Region;
import com.grad.project.nc.service.exceptions.DiscountException;

import java.util.Collection;

/**
 * Created by Alex on 5/16/2017.
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
