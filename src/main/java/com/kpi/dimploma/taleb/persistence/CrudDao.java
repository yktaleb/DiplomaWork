package com.kpi.dimploma.taleb.persistence;

import java.util.List;

public interface CrudDao<T> {

    T add(T entity);

    T update(T entity);

    T find(Long id);

    List<T> findAll();

    default List<T> findAll(long size, long offset) {
        throw new UnsupportedOperationException();
    }

    void delete(Long id);
}
