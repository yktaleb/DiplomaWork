package com.kpi.dimploma.taleb.service.profile;

import com.kpi.dimploma.taleb.model.User;
import com.kpi.dimploma.taleb.service.exceptions.IncorrectUserDataException;
import org.springframework.stereotype.Service;

public interface ProfileService {

    public User updateGeneralInformation(User user) throws IncorrectUserDataException;

    public User updatePassword(User user, String currentPassword, String newPassword) throws IncorrectUserDataException;

    public void validationGeneralInformation(User user) throws IncorrectUserDataException;

    public String getStatus();
}
