package com.company;

public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    void sayHelloTo(Person person) {
        System.out.println("Hi " + person.name + "!");
    }

    //inaczej jesli wywolamy teachera w obiekcie klasy Subject to dostaniemy adres pamieci, a nie nazwe nauczyciela
    @Override
    public String toString() {
        return name;
    }


}
