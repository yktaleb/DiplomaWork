package com.kpi.dimploma.taleb.controller.api.dto.instance;

import lombok.Builder;
import lombok.Data;


/**
 * Created by Taleb on 5/27/2018.
 */
@Data
@Builder
public class FrontendInstanceAddress {

    private String apartment;
    private String city;
    private String street;
    private String building;



}
