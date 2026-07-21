

import java.awt.*;

public class Circle extends Shape{
    private double radius;
    private final double PI=3.1416;
    public Circle(double radius){
        if(radius<0) throw new IllegalArgumentException("Radius cannot be negative");
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public double area(){
        return PI*radius*radius;
    }
    public String describe(){
        return "This is a Circle with radius "+radius;
    }
    public void draw(Canvas canvas) throws ShapeException{
           if(area()<1) throw new ShapeTooSmallException("area cannot be less than 1");
           if(area()>canvas.capacity()) throw new ShapeTooLargeException("area cannot greater than "+canvas.capacity());
           canvas.circle(radius);
    }

}
