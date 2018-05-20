package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.ProductType;

import java.util.List;

public interface ProductTypeDao extends CrudDao<ProductType> {

    ProductType findByName(String productTypeName);

    List<ProductType> findValuableAndActiveByRegionId(Long regionId);

    List<ProductType> findPaginated(int page, int amount);

    ProductType findByProductId(Long productId);

    List<ProductType> findByNameContaining(String productTypeName);

    List<ProductType> findLastN(int n);

    List<ProductType> findFirstN(int n);

    int countTotalProducts();
}
