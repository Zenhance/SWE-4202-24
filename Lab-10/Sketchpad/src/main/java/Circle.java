package main.java;

import java.awt.*;

public class Circle extends Shape{
    private double radius;
    private final double PI=3.1416;
    public Circle(double radius){
        if(radius<0) throw new IllegalArgumentException("Radius cannot be negative");
        this.radius=radius;
    }
    public double area(){
        return PI*radius*radius;
    }
    public String describe(){
        return "This is a Circle with radius "+radius;
    }
    public void draw(Canvas canvas) throws ShapeException{

    }
}
