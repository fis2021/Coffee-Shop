package org.fis2021.exceptions;

public class UsernameAlreadyExists extends Exception {

    private String username;

    public UsernameAlreadyExists(String username) {
        super(String.format("Contul cu username-ul %s exista deja!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
