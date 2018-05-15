package com.grad.project.nc.persistence;

import com.grad.project.nc.model.ProductOrder;

import java.util.List;

public interface ProductOrderDao extends CrudDao<ProductOrder> {

    List<ProductOrder> findByUserId(Long id);

    List<ProductOrder> findByProductName(String productName);

    List<ProductOrder> findByUserLastName(String lastName);

    List<ProductOrder> findByUserPhoneNumber(String phoneNumber);

    List<ProductOrder> findByProductInstanceId(Long id);

    List<ProductOrder> findByProductInstanceId(Long id, Long size, Long offset);

    List<ProductOrder> findByUserId(Long userId, long size, long offset);

    List<ProductOrder> findOpenOrdersByInstanseId(Long instanceId, long size, long offset);

    List<ProductOrder> findByAim(String aim, Long size, Long offset);

    List<ProductOrder> findByStatus(String status, Long size, Long offset);

    List<ProductOrder> findByAimAndStatus(String aim, String status, Long size, Long offset);
}