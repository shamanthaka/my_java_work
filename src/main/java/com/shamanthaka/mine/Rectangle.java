package com.shamanthaka.mine;

public class Rectangle implements Polygon {
    private float length;
    private float breadth;
    public Rectangle(float length, float breadth){
        this.length = length;
        this.breadth = breadth;
    }

    public void calcArea(){
        float area = this.length * this.breadth;
        System.out.println("Area is : "+ area);
    }
    public void calcPeri(){
        float perimetre = 2 *( this.length + this.breadth);
        System.out.println("Perimeter is : " +perimetre);
    }
}
