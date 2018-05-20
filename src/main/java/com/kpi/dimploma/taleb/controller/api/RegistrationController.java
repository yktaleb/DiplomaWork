package com.kpi.dimploma.taleb.controller.api;

import com.kpi.dimploma.taleb.controller.api.data.RegistrationResponseHolder;
import com.kpi.dimploma.taleb.model.User;
import com.kpi.dimploma.taleb.service.exceptions.IncorrectUserDataException;
import com.kpi.dimploma.taleb.service.notifications.EmailService;
import com.kpi.dimploma.taleb.service.security.AutoLoginService;
import com.kpi.dimploma.taleb.service.security.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

//    private UserService userService;
//    private EmailService emailService;
//
//    @Autowired
//    public RegistrationController(UserService userService, EmailService emailService) {
//        this.userService = userService;
//        this.emailService = emailService;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public Map register(@RequestParam("firstName") String firstName,
//                        @RequestParam("lastName") String lastName,
//                        @RequestParam("email") String email,
//                        @RequestParam("password") String password,
//                        @RequestParam("phone") String phone) {
//
//        User user = userService.createUser(firstName, lastName, email, password, phone, Collections.singletonList("CLIENT"));
//        emailService.sendRegistrationEmail(user);
//
//        return Collections.singletonMap("status", "success");
//    }

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AutoLoginService autoLoginService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public RegistrationResponseHolder registration(@RequestBody User user) {

        RegistrationResponseHolder registrationResponse = new RegistrationResponseHolder();

        try {
            registrationService.validation(user);
            registrationService.register(user);
            registrationResponse.setMessage("You've been registered successfully");
            emailService.sendRegistrationEmail(user);
            autoLoginService.autologin(user.getEmail(), user.getPassword());
        } catch (IncorrectUserDataException e) {
            registrationResponse.setMessage(e.getMessage());
        }
        registrationResponse.setStatus(registrationService.getStatus());

        return registrationResponse;
    }
}
