public class Circle extends Shape {
    private double  radius;
    public Circle(double radius) {
        if(radius <= 0) {
            throw new IllegalArgumentException("radius must be positive");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public String describe() {
        return "Circle";
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        if(canvas.capacity()<area()){
            throw new ShapeTooLargeException();
        }
        if(area()<1){
            throw new ShapeTooSmallException();
        }

        canvas.circle(radius);

    }
}
