package com.kpi.dimploma.taleb.service.notifications;

import com.kpi.dimploma.taleb.model.Complain;
import com.kpi.dimploma.taleb.model.ProductInstance;
import com.kpi.dimploma.taleb.model.ProductOrder;
import com.kpi.dimploma.taleb.model.User;
import sun.security.jca.GetInstance;

public interface EmailService {
    void sendRegistrationEmail(User user);
    void sendNewOrderEmail(ProductOrder order);
    void sendInstanceStatusChangedEmail(ProductInstance instance);
    void sendNewComplaintEmail(Complain complain);
    void sendComplaintUnderConsiderationChangedEmail(Complain complain);
    void sendComplaintCompleteEmail(Complain complain);
}
