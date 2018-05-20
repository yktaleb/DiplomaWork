package com.kpi.dimploma.taleb.service;

import com.kpi.dimploma.taleb.persistence.CrudDao;

import java.util.List;

public abstract class AbstractService<T> implements CrudService<T> {
    @Override
    public T add(T entity) {
        return getBackingDao().add(entity);
    }

    @Override
    public T update(T entity) {
        return getBackingDao().update(entity);
    }

    @Override
    public T find(Long id) {
        return getBackingDao().find(id);
    }

    @Override
    public List<T> findAll() {
        return getBackingDao().findAll();
    }

    public abstract CrudDao<T> getBackingDao();
}
