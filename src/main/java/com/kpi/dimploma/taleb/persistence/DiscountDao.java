package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.Discount;

import java.util.List;

public interface DiscountDao extends CrudDao<Discount> {

    List<Discount> findByProductRegionPriceId(Long productRegionPriceId);
    void deleteDiscountProductPrices(Long userId);
    void persistDiscountProductPrices(Discount discount);

    Discount findLargestDiscountByPriceId(Long priceId);
}
