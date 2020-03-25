package com.company;

public class NoSimcardException extends Exception{
    NoSimcardException(){
        super("brak karty SIM!");
    }

}
