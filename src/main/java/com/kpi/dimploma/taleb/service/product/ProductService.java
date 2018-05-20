package com.kpi.dimploma.taleb.service.product;

import com.kpi.dimploma.taleb.model.Product;
import com.kpi.dimploma.taleb.service.CrudService;
import com.kpi.dimploma.taleb.support.pagination.Page;

import java.util.List;

public interface ProductService extends CrudService<Product> {

    Product findCatalogProduct(Long id);

    Page<Product> findPaginated(int page, int amount);

    Page<Product> findActiveByProductTypeIdAndRegionIdPaginated(Long productTypeId, Long regionId,
                                                                int page, int amount);

    List<Product> findLastN(int n);

    List<Product> findByNameContaining(String productName);

    List<Product> findByNameContaining(String productName, Long productTypeId, Long regionId);

    List<Product> findByProductTypeId(Long productTypeId);

    List<Product> findCatalogProductsByRegionId(Long regionId);
}
