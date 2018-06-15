package com.kpi.dimploma.taleb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Taleb on 4/24/2018.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long addressId;
    private String apartmentNumber;
    private Location location;
}