package com.kpi.dimploma.taleb.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleOld implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
