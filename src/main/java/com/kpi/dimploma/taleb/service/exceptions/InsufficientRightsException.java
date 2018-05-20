package com.kpi.dimploma.taleb.service.exceptions;

import com.kpi.dimploma.taleb.service.orders.OrdersService;

public class InsufficientRightsException extends OrderException {
    public InsufficientRightsException(String message) {
        super(message);
    }
}
