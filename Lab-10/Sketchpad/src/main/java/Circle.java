package main.java;
import java.awt.*;


public class Circle extends Shape{
    private  double radius;

    public Circle(double radius) {
        if(radius<0){
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }

    @Override
    public void draw(Canvas canvas) throws ShapeTooLargeException, ShapeTooSmallException {
        if(area()<1){
            throw new ShapeTooSmallException("Radius must be bigger than 1");
        }
        if(area()> canvas.capacity()){
            throw new ShapeTooLargeException("Area is too big");
        }
        canvas.circle(radius);
    }

    @Override
    public String describe() {
        return "This is a circle with a radius of" + radius+ "and it's area is" + area() ;
    }
}
