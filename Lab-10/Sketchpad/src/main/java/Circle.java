public class Circle extends Shape{

    private double radius;

    public Circle(double radius){
        if(radius <= 0){
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius <= 0){
            throw new IllegalArgumentException("Radius must be positive");
        }
    }

    @Override
    public double area(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }


    @Override
    public String describe(double radius, double area) {
        return String.format("Area of circle with radius %.2f is %.2f", radius, area());
    }


    @Override
    public void printOn(Canvas canvas) {

    }
}
