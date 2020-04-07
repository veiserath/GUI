package com.company;

public class ProblematicTenantException extends Exception {
//    int iloscPomieszczen;

    ProblematicTenantException(String pomieszczenia){
        super("Osoba X posiadała już najem pomieszczeń: " + pomieszczenia);
    }

}
