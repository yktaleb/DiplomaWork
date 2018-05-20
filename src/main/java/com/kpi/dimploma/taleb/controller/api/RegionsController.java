package com.kpi.dimploma.taleb.controller.api;

import com.kpi.dimploma.taleb.model.Region;
import com.kpi.dimploma.taleb.persistence.CrudDao;
import com.kpi.dimploma.taleb.persistence.RegionDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user/regions/")
public class RegionsController {
    private CrudDao<Region> regionsDao;

    @Autowired
    public RegionsController(RegionDao regionsDao) {
        this.regionsDao = regionsDao;
    }

    @RequestMapping("/all")
    public Collection<SimpleRegion> test() {
        return regionsDao.findAll().stream()
                .map((item) -> new SimpleRegion(item.getRegionId(), item.getRegionName()))
                .collect(Collectors.toList());
    }

    @Data
    @AllArgsConstructor
    private static class SimpleRegion {
        private Long regionId;
        private String regionName;
    }
}
