package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.ProductCharacteristicValue;

import java.util.List;

public interface ProductCharacteristicValueDao extends CrudDao<ProductCharacteristicValue> {

    ProductCharacteristicValue find(Long productId, Long productCharacteristicId);

    void delete(Long productId, Long productCharacteristicId);

    void deleteBatch(List<ProductCharacteristicValue> values);

    void updateBatch(List<ProductCharacteristicValue> values);

    List<ProductCharacteristicValue> findByProductId(Long productId);

    void deleteByProductId(Long productId);

    void persistBatch(List<ProductCharacteristicValue> values);
}
