public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String describe() {
        return String.format("Circle(radius=%.2f, area=%.2f)", radius, area());
    }

    @Override
    public void draw(Canvas canvas) throws ShapeDrawException {
        if (area() > canvas.capacity()) {
            throw new ShapeTooLargeException(describe() + " is too large for canvas");
        }
        if (area() < 1.0) {
            throw new ShapeTooSmallException(describe() + " is too small to cover one cell");
        }
        canvas.circle(radius);
    }
}