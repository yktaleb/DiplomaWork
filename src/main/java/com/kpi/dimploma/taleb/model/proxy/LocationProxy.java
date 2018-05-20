package com.kpi.dimploma.taleb.model.proxy;

import com.kpi.dimploma.taleb.model.Location;
import com.kpi.dimploma.taleb.model.Region;
import com.kpi.dimploma.taleb.persistence.RegionDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LocationProxy extends Location {
    @Getter @Setter
    private Long regionId;

    private boolean regionLoaded;

    private RegionDao regionDao;

    @Autowired
    public LocationProxy(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    public Region getRegion() {
        if (!regionLoaded) {
            this.setRegion(regionDao.find(getRegionId()));
        }
        return super.getRegion();
    }

    @Override
    public void setRegion(Region region) {
        regionLoaded = true;
        super.setRegion(region);
    }
}