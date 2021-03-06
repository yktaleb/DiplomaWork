package com.kpi.dimploma.taleb.controller.api.pmg;

import com.kpi.dimploma.taleb.controller.api.dto.FrontendDomain;
import com.kpi.dimploma.taleb.model.User;
import com.kpi.dimploma.taleb.service.domains.DomainService;
import com.kpi.dimploma.taleb.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by DeniG on 17.05.2017.
 */
@RestController
@RequestMapping("/api/pmg/domains")
public class PmgDomainController {
    DomainService domainService;
    UserService userService;
    @Autowired
    public PmgDomainController(DomainService domainService, UserService userService) {
        this.domainService = domainService;
        this.userService = userService;
    }
    @RequestMapping(value = "/find/bymail/{email}", method = RequestMethod.GET)
    Map<String, Object> findByUserEMail(@PathVariable String email) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.findByEMail(email);
        if (user != null) {
            result.put("status", "found");
            result.put("userId", user.getUserId());
            result.put("domains",
                    domainService.getAllDomains(user.getUserId())
                            .stream()
                            .map(FrontendDomain::fromEntity)
                            .collect(Collectors.toCollection(ArrayList::new)));
        } else {
            result.put("status", "not found");
        }

        return result;

    }
}
