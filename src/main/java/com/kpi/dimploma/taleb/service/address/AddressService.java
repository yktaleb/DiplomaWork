package com.kpi.dimploma.taleb.service.address;

import com.kpi.dimploma.taleb.model.Address;

public interface AddressService {
    Address findByDomainId(Long domainId);
}
