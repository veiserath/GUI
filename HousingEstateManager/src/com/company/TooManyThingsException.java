package com.company;

public class TooManyThingsException extends Exception {
    public TooManyThingsException() {
        super("Remove some items to insert a new item");
    }
}
