public class Circle extends Shape{
    public final double radius;
    public Circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("radius must be positive, got " +  radius);
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public String describe() {
        return String.format ("Circle(radius=%.2f, area=%.2f)", radius, area());
    }
    @Override
    public void draw(Canvas canvas) throws ShapeException{
        double area =area();
        if (area > canvas.capacity()) throw new ShapeTooLargeException(describe() + " does not fit in canvas of capacity " + canvas.capacity());
    }
}