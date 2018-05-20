package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.ProductCharacteristic;

import java.util.List;

public interface ProductCharacteristicDao extends CrudDao<ProductCharacteristic> {

    List<ProductCharacteristic> findByProductTypeId(Long productTypeId);

    List<ProductCharacteristic> findByDataTypeId(Long dataTypeId);

    void updateBatch(List<ProductCharacteristic> productCharacteristics);

    void deleteBatch(List<ProductCharacteristic> productCharacteristics);

    void persistBatch(List<ProductCharacteristic> productCharacteristics);

    void deleteByProductTypeId(Long productTypeId);
}
