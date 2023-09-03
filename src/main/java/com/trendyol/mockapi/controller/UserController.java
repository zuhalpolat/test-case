package com.trendyol.mockapi.controller;

import com.trendyol.mockapi.model.response.UserInfo;
import com.trendyol.mockapi.properties.CredentialsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
public class UserController {
    private final CredentialsProperties credentialsProperties;

    @GetMapping(value = "user")
    public UserInfo login() {
        return UserInfo.builder()
                .username(credentialsProperties.getUsername())
                .password(credentialsProperties.getPassword())
                .build();
    }
}
