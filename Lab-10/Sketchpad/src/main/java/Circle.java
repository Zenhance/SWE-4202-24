public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be > 0");
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
        return "Circle(radius=" + radius + ")";
    }

    @Override
    public void draw(Canvas canvas) throws ShapeDrawException {

        if (area() < 1) {
            throw new ShapeTooSmallException(describe() + " would cover less than one cell");
        }

        if (area() > canvas.capacity()) {
            throw new ShapeTooLargeException(describe() + " exceeds canvas capacity " + canvas.capacity());
        }

        canvas.circle(radius);
    }
}