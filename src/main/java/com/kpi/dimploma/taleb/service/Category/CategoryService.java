package com.kpi.dimploma.taleb.service.Category;

import com.kpi.dimploma.taleb.model.Category;
import com.kpi.dimploma.taleb.model.ProductInstance;

import java.util.Collection;

/**
 * Created by Taleb on 11.05.2018.
 */
public interface CategoryService {
    public Category getByProductInstanceId(Long productInstanceId);
    public Collection<Category> findByCategoryTypeName(String categoryTypeName);
    public Collection<Category> findByCategoryType(long categoryTypeId);
}
