public class Circle extends Shape {
    private double radius;
    private final double PI = 3.1416;

    public Circle(double radius) {
        if(radius < 0) throw new IllegalArgumentException("Radius can't be negative");
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI*radius*radius;
    }

    @Override
    public String description() {
        return ("The radius of the circle is: " +radius+ "& the area is: " + area());
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        if(area()<1) throw new ShapeTooSmallException("Impossible!");
        else if(area()> canvas.capacity()) throw new ShapeTooLargeException("Area can't be greater than canvas capacity");
        canvas.circle(radius);
    }

}
