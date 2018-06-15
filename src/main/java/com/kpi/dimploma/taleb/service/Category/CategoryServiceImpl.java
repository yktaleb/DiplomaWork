package com.kpi.dimploma.taleb.service.Category;

import com.kpi.dimploma.taleb.model.Category;
import com.kpi.dimploma.taleb.model.ProductInstance;
import com.kpi.dimploma.taleb.persistence.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Taleb on 11.05.2018.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public Category getByProductInstanceId(Long productInstanceId) {
        return categoryDao.findProductInstanceStatus(productInstanceId);
    }

    @Override
    public Collection<Category> findByCategoryTypeName(String categoryTypeName) {
        return categoryDao.findByCategoryTypeName(categoryTypeName);
    }

    @Override
    public Collection<Category> findByCategoryType(long categoryTypeId) {
        return categoryDao.findByCategoryTypeId(categoryTypeId);
    }
}
