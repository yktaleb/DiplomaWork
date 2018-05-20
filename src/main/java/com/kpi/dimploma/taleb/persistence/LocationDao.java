package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.Location;

import java.util.List;

public interface LocationDao extends CrudDao<Location> {

    Location findAddressLocationById(Long addressId);

    List<Location> findByRegionId(Long regionId);
}
