public class Circle extends Shape {

    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius: " + radius + " has to be positive");
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String describe() {
        return String.format("Circle [r = %.2f]", radius);
    }

    @Override
    public void draw(Canvas canvas) throws DrawException {
        checkFit(canvas);
        canvas.circle(radius);
    }
}
