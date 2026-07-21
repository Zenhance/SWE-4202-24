public class Circle extends Shape{
    private double radius;
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Circle radius must be positive, got " + radius);
        }
        this.radius = radius;
    }
}
