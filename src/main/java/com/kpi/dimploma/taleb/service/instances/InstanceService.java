package com.kpi.dimploma.taleb.service.instances;

import com.kpi.dimploma.taleb.controller.api.dto.instance.FrontendInstance;
import com.kpi.dimploma.taleb.model.ProductInstance;

import java.util.Collection;

public interface InstanceService {
    ProductInstance getById(Long id);
    boolean isInstanceOwnedBy(long instanceId, long userId);
    Collection<ProductInstance> getByDomainId(Long domainId);
    Collection<ProductInstance> getAll();
    Collection<ProductInstance> getAllPage(Long size, Long offset);
    Collection<ProductInstance> getByUserId(Long id, Long size, Long offset);
    Collection<ProductInstance> getAllByStatusId(Long size, Long offset, Long statusId);
    FrontendInstance setAddressAndDiscount(FrontendInstance frontendInstance);

    }
