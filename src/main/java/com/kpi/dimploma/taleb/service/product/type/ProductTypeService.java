package com.kpi.dimploma.taleb.service.product.type;

import com.kpi.dimploma.taleb.model.Category;
import com.kpi.dimploma.taleb.model.ProductType;
import com.kpi.dimploma.taleb.service.CrudService;
import com.kpi.dimploma.taleb.support.pagination.Page;

import java.util.List;

public interface ProductTypeService extends CrudService<ProductType> {

    List<ProductType> findValuableAndActiveByRegionId(Long regionId);

    List<ProductType> findLastN(int n);

    List<ProductType> findByNameContaining(String productTypeName);

    Page<ProductType> findPaginated(int page, int amount);

    List<Category> findProductCharacteristicDataTypes();
}
