package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.Domain;
import com.kpi.dimploma.taleb.model.User;

import java.util.List;

public interface DomainDao extends CrudDao<Domain> {

    List<Domain> findByUserId(Long userId);

    void deleteDomainUser(Long domainId, Long userId);

    void deleteDomainUsers(Long domainId);

    void addDomainUser(Long domainId, Long userId);
}
