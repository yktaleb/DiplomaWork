package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.Region;

public interface RegionDao extends CrudDao<Region> {

    Region findLocationRegionById(Long locationId);

    Region findByProductRegionPriceId(Long productRegionPriceId);

    Region findByName(String name);
}
