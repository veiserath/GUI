package com.company.kopia;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{
            GameWindow gameWindow = new GameWindow();
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
