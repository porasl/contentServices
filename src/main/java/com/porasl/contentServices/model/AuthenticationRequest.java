package com.porasl.contentServices.model;

public class AuthenticationRequest {

    private String username;
    private String password;

    // Default constructor for JSON Parsing
    public AuthenticationRequest() {

    }

    public AuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
