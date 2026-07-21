 public class Circle extends Shape{
    private final double radius;

    public Circle(double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("Radius must be greater than 0"  + radius);
        }
        this.radius = radius;
    }
    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    @Override
    public String describe(){
        return String.format("Area of circle: %.1f", area());
    }
 }
