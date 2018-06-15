package com.kpi.dimploma.taleb.controller.api.dto;

import com.kpi.dimploma.taleb.model.User;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Taleb on 10.05.2018.
 */

@Data
@Builder
public class FrontendUser {
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public static FrontendUser fromEntity(User user){
        return builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public User toModel(){
        return User.builder()
                .userId(getUserId())
                .email(getEmail())
                .firstName(getFirstName())
                .lastName(getLastName())
                .phoneNumber(getPhoneNumber())
                .build();
    }
}
