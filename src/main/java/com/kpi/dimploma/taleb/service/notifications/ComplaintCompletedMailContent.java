package com.kpi.dimploma.taleb.service.notifications;

import com.kpi.dimploma.taleb.model.Complain;

/**
 * Created by DeniG on 22.05.2017.
 */
public class ComplaintCompletedMailContent extends MailContent {
    public ComplaintCompletedMailContent(Complain complain) {
        getContext().put("complaint", complain);
        getContext().put("user", complain.getUser());

        setSender("support@taleb.kpi.com");
        setSubject("Complaint complete!");

        setTemplateName("complaintComplete.ftl");
    }
}
