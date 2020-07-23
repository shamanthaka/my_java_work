package com.shamanthaka.assignment2;

public class Square implements Polygon{
    private float side;
    public Square(float side){
        this.side = side;
    }

    public void calcArea() {
        float area = this.side * this.side;
        System.out.println(" area is  " + area);
    }

    public void calcPeri() {
        float perimetre = this.side * 4;
        System.out.println(" perimetre is "+ perimetre);
    }
}
