package main.java;

import java.awt.*;

public class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public String describe() {
        return "";
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        canvas.rectangle(width, height);

    }

}
