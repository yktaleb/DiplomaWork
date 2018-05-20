package com.kpi.dimploma.taleb.service.address;

import com.kpi.dimploma.taleb.model.Address;
import com.kpi.dimploma.taleb.persistence.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    @Override
    public Address findByDomainId(Long domainId) {
        return addressDao.findDomainAddressById(domainId);
    }
}
