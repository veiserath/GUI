package com.company;

public class Square implements Comparable<Square>,Figure{
    int length;
    int number;
    static int counter;
    Square(int length) throws TooBigSquareException {
        counter++;
        this.number = counter;
        this.length = length;
        if (length > 6){
            throw new TooBigSquareException();
        }
    }

    public int getArea(){
        return this.length*this.length;

    }

    @Override
    public int getPerimeter() {
        return 0;
    }

    public String toString(){
        return "(" + number + "): " + getArea();
    }
    public int compareTo(Square other){
    if (this.getArea() < other.getArea()){
        return -1;
    }
    if (this.getArea() == other.getArea()){
        return 0;
    }
    return 1;
    }

}
