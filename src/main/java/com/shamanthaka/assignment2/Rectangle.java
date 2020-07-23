package com.shamanthaka.assignment2;

public class Rectangle implements Polygon {
    private float length;
    private float breadth;
    public Rectangle(float l, float b){
        this.length = l;
        this.breadth = b;
    }

    public void calcArea() {
        float area = this.length * this.breadth;
        System.out.println(" area is : "+ area);
    }

    public void calcPeri() {
        float perimetre = 2* (this.length + this.breadth);
        System.out.println("perimeter is : " + perimetre);

    }
}
