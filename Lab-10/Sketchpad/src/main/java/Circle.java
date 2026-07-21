package main.java;

public class Circle extends Shape{
    private double radius;

    public Circle (double radius){
        this.radius = radius;
    }
    public double area(){
        return 3.14 *radius *radius;
    }

    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String describe() {
        return String.format("Circle(%.2f)", getRadius());
    }



}
