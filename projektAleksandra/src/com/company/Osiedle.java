package com.company;

import java.util.ArrayList;
import java.util.List;

public class Osiedle {

    private List<Mieszkanie> listaMieszkanwynajetych = new ArrayList<>();
    private List<Mieszkanie> listaMieszkanwolnych = new ArrayList<>();
    private List<MiejsceParkingowe> listaMPzajetych = new ArrayList<>();

    public void setListaMieszkanwynajetych(List<Mieszkanie> listaMieszkanwynajetych) {
        this.listaMieszkanwynajetych = listaMieszkanwynajetych;
    }

    public void setListaMieszkanwolnych(List<Mieszkanie> listaMieszkanwolnych) {
        this.listaMieszkanwolnych = listaMieszkanwolnych;
    }

    public void setListaMPzajetych(List<MiejsceParkingowe> listaMPzajetych) {
        this.listaMPzajetych = listaMPzajetych;
    }

    public void setListaMPwolnych(List<MiejsceParkingowe> listaMPwolnych) {
        this.listaMPwolnych = listaMPwolnych;
    }

    private List<MiejsceParkingowe> listaMPwolnych = new ArrayList<>();

    public List<Mieszkanie> getListaMieszkanwynajetych() {
        return listaMieszkanwynajetych;
    }

    public List<Mieszkanie> getListaMieszkanwolnych() {
        return listaMieszkanwolnych;
    }

    public List<MiejsceParkingowe> getListaMPzajetych() {
        return listaMPzajetych;
    }

    public List<MiejsceParkingowe> getListaMPwolnych() {
        return listaMPwolnych;
    }
}
