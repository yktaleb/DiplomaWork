package com.kpi.dimploma.taleb.service.notifications;


import com.kpi.dimploma.taleb.model.ProductInstance;
import com.kpi.dimploma.taleb.model.User;
import com.kpi.dimploma.taleb.service.instances.InstanceService;

public class InstanceStatusChangedMailContent extends MailContent {
    InstanceStatusChangedMailContent(User user, ProductInstance instance) {
        getContext().put("instance", instance);
        getContext().put("user", user);

        setSender("support@taleb.kpi.com");
        setSubject("Instance status changed");

        setTemplateName("instanceStatusChange.ftl");
    }
}
