public class Circle extends Shape{

    private final double radius;

    public Circle(double radius){
        if(radius <= 0){
            throw new IllegalArgumentException("Circle radius must be positive, got " + radius);
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String describe() {
        return String.format("Circle: Radius = %.2f, Area = %.2f", radius, area());
    }

    @Override
    public void printOn(Canvas canvas) {
        canvas.circle(radius);
    }
}
