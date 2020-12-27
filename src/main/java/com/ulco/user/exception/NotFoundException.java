package com.ulco.user.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("La ressource est introuvable.");
    }

}
