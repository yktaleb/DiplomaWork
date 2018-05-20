package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.Product;

import java.util.List;

public interface ProductDao extends CrudDao<Product> {
    List<Product> findPaginated(int page, int amount);

    List<Product> findByRegionId(Long regionId);

    List<Product> findActiveByRegionId(Long regionId);

    Product findByName(String productName);

    List<Product> findByNameContaining(String productName);

    List<Product> findFirstN(int n);

    List<Product> findLastN(int n);

    List<Product> findByProductTypeId(Long productTypeId);

    Product findByProductRegionPriceId(Long productRegionPriceId);

    int countTotalProducts();

    List<Product> findActiveByProductTypeIdAndRegionIdPaginated(Long productTypeId, Long regionId,
                                                                int page, int amount);

    int countActiveProductsOf(Long productTypeId, Long regionId);

    List<Product> findByNameContaining(String productName, Long productTypeId, Long regionId);
}