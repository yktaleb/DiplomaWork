package com.kpi.dimploma.taleb.service.notifications;

import com.kpi.dimploma.taleb.model.ProductOrder;

class NewOrderMailContent extends MailContent {
    NewOrderMailContent(ProductOrder order) {
        getContext().put("order", order);

        setSender("support@taleb.kpi.com");
        setSubject("New order");

        setTemplateName("newOrder.ftl");
    }
}
