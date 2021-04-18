package org.fis2021.exceptions;

public class InvalidCredentials extends Exception{
    private String username;
    public InvalidCredentials(String username) {
        super(String.format("Numele de utilizator %s este invalid!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}