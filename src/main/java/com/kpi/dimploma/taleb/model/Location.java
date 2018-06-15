package com.kpi.dimploma.taleb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Taleb on 4/29/2018.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Long locationId;
    private String googlePlaceId;
    private Region region;
}
