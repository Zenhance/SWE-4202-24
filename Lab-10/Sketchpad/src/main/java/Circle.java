public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        if(radius <= 0){
            throw new IllegalArgumentException("radius must be positive");
        }
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        if(radius <= 0){
            throw new IllegalArgumentException("radius must be positive");
        }
        this.radius = radius;
    }
    @Override
    public double area() {
        if(radius <= 0){
            throw new IllegalArgumentException("radius must be positive");
        }
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String describe() {
        return "Circle(" + radius + ")";
    }

    @Override
    public void paint(Canvas canvas) {
        canvas.circle(radius);
    }
}
