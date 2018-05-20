package com.kpi.dimploma.taleb.service.domains;

import com.kpi.dimploma.taleb.controller.api.dto.FrontendDomain;
import com.kpi.dimploma.taleb.model.Domain;

import java.util.List;

public interface DomainService {
    Domain find(Long id);

    List<Domain> getAllDomains(Long id);

    void add(Domain domain);

    void update(Domain domain);

    void delete(Domain domain);
}
