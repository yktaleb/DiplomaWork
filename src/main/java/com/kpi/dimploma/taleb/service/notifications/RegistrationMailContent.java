package com.kpi.dimploma.taleb.service.notifications;

import com.kpi.dimploma.taleb.model.User;

import java.io.IOException;

class RegistrationMailContent extends MailContent {

    RegistrationMailContent(User user) {
        context.put("user", user);

        setSender("support@taleb.kpi.com");
        setSubject("Welcome");

        setTemplateName("registration.ftl");
    }
}
