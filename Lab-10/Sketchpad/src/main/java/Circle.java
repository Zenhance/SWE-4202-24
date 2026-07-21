public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Circle must be greater than zero.");
        }

        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String describe() {
        return "Circle (radius = " + radius + ", area = " + area() + ")";
    }

}
