package main.java;

import java.awt.*;

public class Circle extends Shape{
    public double radius;
    public Circle(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Radius must be positive and it can not be 0");
        }
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public String describe() {
        return "Circle";
    }

    @Override
    public void draw(Canvas canvas) throws ShapeTooLargeException, ShapeTooSmallException {
        if (canvas.capacity()>area()){
            throw new ShapeTooLargeException();
        }
        if (canvas.capacity()<1){
            throw new ShapeTooSmallException();
        }
        canvas.circle(radius);

}
}
