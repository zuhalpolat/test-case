package com.trendyol.mockapi.service;

import com.trendyol.mockapi.properties.CredentialsProperties;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final CredentialsProperties credentialsProperties;

    public void isAuthenticated(String username, String password) throws AuthenticationException {
        if (credentialsProperties.getUsername().equals(username) && credentialsProperties.getPassword().equals(password)) {
            return;
        }

        // control et

        throw new AuthenticationException("The username or password is invalid.");
    }
}
