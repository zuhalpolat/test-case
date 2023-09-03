package com.trendyol.mockapi.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "credentials")
public class CredentialsProperties {
    private String username;
    private String password;
}
