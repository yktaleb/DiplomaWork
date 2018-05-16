package com.grad.project.nc.service.notifications;

import com.grad.project.nc.model.ProductOrder;

class NewOrderMailContent extends MailContent {
    NewOrderMailContent(ProductOrder order) {
        getContext().put("order", order);

        setSender("support@taleb.kpi.com");
        setSubject("New order");

        setTemplateName("newOrder.ftl");
    }
}
