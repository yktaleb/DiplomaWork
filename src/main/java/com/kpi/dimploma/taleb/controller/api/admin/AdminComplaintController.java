package com.kpi.dimploma.taleb.controller.api.admin;

import com.kpi.dimploma.taleb.controller.api.dto.FrontendComplain;
import com.kpi.dimploma.taleb.service.complain.ComplainService;
import com.kpi.dimploma.taleb.service.exceptions.IncorrectComplaintStateException;
import com.kpi.dimploma.taleb.service.exceptions.IncorrectRoleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by DeniG on 23.05.2017.
 */

@RestController
@RequestMapping("api/admin/complaint")
public class AdminComplaintController {
    private ComplainService complainService;

    @Autowired
    public AdminComplaintController(ComplainService complainService) {
        this.complainService = complainService;
    }

    @RequestMapping(value = "/get/all/size/{size}/offset/{offset}", method = RequestMethod.GET)
    public Collection<FrontendComplain> getComplains(@PathVariable Long size, @PathVariable Long offset){
        return complainService.getAllComplains(size,offset).stream()
                .map(FrontendComplain :: fromEntity)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @RequestMapping(value = "/set/responsible", method = RequestMethod.POST)
    public Map<String, Object> setResponsible(@RequestBody Map<String, String> params){
        Long complaintId = Long.parseLong(params.get("complaintId"));
        Long responsibleId = Long.parseLong(params.get("responsibleId"));

        Map<String, Object> result = new HashMap<>();

        try {
            complainService.setResponsible(responsibleId, complaintId);
            result.put("status" , "success");
            result.put("message" , "New responsible successfully appointed");
        } catch (IncorrectRoleException | IncorrectComplaintStateException e) {
            result.put("status" , "error");
            result.put("message" , e.getMessage());

        }
        return result;
    }
}


