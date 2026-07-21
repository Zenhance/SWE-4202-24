public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
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
    public void draw(Canvas canvas) throws ShapeException {
        double calArea = area();
        if (calArea < 1.0) {
            throw new ShapeTooSmallException("Too small");
        }
        if (calArea > canvas.capacity()) {
            throw new ShapeTooLargeException("Too Large");
        }
        canvas.circle(radius);
    }

    @Override
    public String describe() {
        return "Circle [radius=" + radius + ", area=" + String.format("%.2f", area()) + "]";
    }
}