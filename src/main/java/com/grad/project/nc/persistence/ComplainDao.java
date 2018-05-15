package com.grad.project.nc.persistence;

import com.grad.project.nc.model.Complain;

import java.util.List;

public interface ComplainDao extends CrudDao<Complain> {

    List<Complain> findByUserId(Long userId);
    List<Complain> findByInstanceId(Long instanceId, long size, long offset);
    List<Complain> findByUserId(Long userId, long size, long offset);
}
