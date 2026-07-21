public class Circle extends Shape{
    private final double radius;

    public Circle(double radius) {
        requirePositive(radius);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    protected void make(Canvas canvas) {
        canvas.circle(radius);
    }

    @Override
    public String description(){
        return "Circle";
    }
}
