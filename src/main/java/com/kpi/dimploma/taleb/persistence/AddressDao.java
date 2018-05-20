package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.Address;

public interface AddressDao extends CrudDao<Address> {

    Address findDomainAddressById(Long domainId);
}