package com.kpi.dimploma.taleb.service.notifications;

import com.kpi.dimploma.taleb.model.Complain;

/**
 * Created by DeniG on 22.05.2017.
 */
public class ComplaintUnderConsiderationMailContent extends MailContent {
    public ComplaintUnderConsiderationMailContent(Complain complain) {
        getContext().put("complaint", complain);
        getContext().put("user", complain.getUser());

        setSender("support@taleb.kpi.com");
        setSubject("Complaint under consideration");

        setTemplateName("complaintUnderConsideration.ftl");
    }
}
