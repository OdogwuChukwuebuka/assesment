package com.interswitch.assesment.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class ApiKeyAuthentication implements Authentication {
    private final String apiKey;
    private boolean authenticated;

    public ApiKeyAuthentication(String apiKey) {
        this.apiKey = apiKey;
        this.authenticated = true; // Assume the API key is valid
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // No authorities needed for API key authentication
    }

    @Override
    public Object getCredentials() {
        return apiKey; // The API key is the credential
    }

    @Override
    public Object getDetails() {
        return null; // No additional details
    }

    @Override
    public Object getPrincipal() {
        return apiKey; // The API key is the principal
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return apiKey; // The API key is the name
    }
}