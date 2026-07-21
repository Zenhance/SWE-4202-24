public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("radius must be positive");
        this.radius = radius;
    }

    @Override
    public double area() { return Math.PI * radius * radius; }

    @Override
    public String describe() { return String.format("Circle(r=%.2f, area=%.2f)", radius, area()); }

    @Override
    public void draw(Canvas canvas) throws ShapeTooLargeException, ShapeTooSmallException {
        double area = area();
        if (area > canvas.capacity()) throw new ShapeTooLargeException(describe() + " too large");
        if (area < 1) throw new ShapeTooSmallException(describe() + " too small");
        canvas.circle(radius);
    }
}