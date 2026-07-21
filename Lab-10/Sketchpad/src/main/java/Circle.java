public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive, got " + radius);
        }
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }
}