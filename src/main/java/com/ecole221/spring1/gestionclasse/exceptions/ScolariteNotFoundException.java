package com.ecole221.spring1.gestionclasse.exceptions;

public class ScolariteNotFoundException extends RuntimeException {
    public ScolariteNotFoundException(String message) {
        super(message);
    }
}
