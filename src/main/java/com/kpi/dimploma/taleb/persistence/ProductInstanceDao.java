package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.ProductInstance;

import java.util.List;

public interface ProductInstanceDao extends CrudDao<ProductInstance> {
    ProductInstance findByProductOrderId(Long productOrderId);

    ProductInstance findByComplainId(Long complainId);

    List<ProductInstance> findByDomainId(Long domainId);

    List<ProductInstance> findByProductRegionPriceId(Long productRegionPriceId);

    List<ProductInstance> findByUserId(Long id, Long size, Long offset);
    List<ProductInstance> findByStatus( Long size, Long offset, Long statusId);

    }
