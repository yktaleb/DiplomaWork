package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.CategoryType;

public interface CategoryTypeDao extends CrudDao<CategoryType> {
    CategoryType findCategoryTypeByCategoryId(Long categoryId);
}
