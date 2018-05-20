package com.kpi.dimploma.taleb.model.proxy;

import com.kpi.dimploma.taleb.model.Location;
import com.kpi.dimploma.taleb.model.ProductRegionPrice;
import com.kpi.dimploma.taleb.model.Region;
import com.kpi.dimploma.taleb.persistence.LocationDao;
import com.kpi.dimploma.taleb.persistence.ProductRegionPriceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class RegionProxy extends Region {

    private boolean locationsLoaded;
    private boolean pricesLoaded;

    private final LocationDao locationDao;
    private final ProductRegionPriceDao productRegionPriceDao;

    @Autowired
    public RegionProxy(LocationDao locationDao, ProductRegionPriceDao productRegionPriceDao) {
        this.locationDao = locationDao;
        this.productRegionPriceDao = productRegionPriceDao;
    }

//    @Override
//    public List<Location> getLocations() {
//        if (!locationsLoaded) {
//            this.setLocations(locationDao.findByRegionId(getRegionId()));
//        }
//
//        return super.getLocations();
//    }
//
//    @Override
//    public void setLocations(List<Location> locations) {
//        locationsLoaded = true;
//        super.setLocations(locations);
//    }

    @Override
    public List<ProductRegionPrice> getPrices() {
        if (!pricesLoaded) {
            this.setPrices(productRegionPriceDao.findByRegionId(getRegionId()));
        }

        return super.getPrices();
    }

    @Override
    public void setPrices(List<ProductRegionPrice> prices) {
        pricesLoaded = true;
        super.setPrices(prices);
    }
}
