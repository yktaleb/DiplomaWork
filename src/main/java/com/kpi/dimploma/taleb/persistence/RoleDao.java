package com.kpi.dimploma.taleb.persistence;

import com.kpi.dimploma.taleb.model.Role;

import java.util.List;

public interface RoleDao extends CrudDao<Role> {
    Role findByName(String roleName);

    List<Role> findUserRolesById(Long userId);
}
