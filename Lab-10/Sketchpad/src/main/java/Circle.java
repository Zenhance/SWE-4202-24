public class Circle extends Shape{
    private double radius;
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Circle radius must be positive, got " + radius);
        }
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public String describe() {
        return String.format("Circle with radius %.2f (area %.2f)", radius, area());
    }
    @Override
    public void paint(Canvas canvas) {
        canvas.circle(radius);
    }
}
