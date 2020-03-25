package com.company;

public class NoInternetException extends Exception {
    public NoInternetException() {
        super("Nie ma internetu!");
    }
}
