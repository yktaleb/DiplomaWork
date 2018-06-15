package com.kpi.dimploma.taleb.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taleb on 16.05.2018.
 */
@Controller
public class PmgPages {
    @RequestMapping("/pmg/complains")
    public  String complainspage(){
        return ("/pmg/complains");
    }
}
