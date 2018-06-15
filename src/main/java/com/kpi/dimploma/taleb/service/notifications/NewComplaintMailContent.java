package com.kpi.dimploma.taleb.service.notifications;

import com.kpi.dimploma.taleb.model.Complain;

/**
 * Created by Taleb on 22.05.2018.
 */
public class NewComplaintMailContent extends MailContent {
    public NewComplaintMailContent(Complain complain) {
        getContext().put("complaint", complain);
        getContext().put("user", complain.getUser());

        setSender("support@taleb.kpi.com");
        setSubject("Complaint created");

        setTemplateName("newComplaint.ftl");
    }
}
