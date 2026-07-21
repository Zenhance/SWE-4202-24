public class Circle extends Shape{
    private double radius;
    private final double PI = 3.1416;

    public Circle(double radius){
        if (radius < 0) throw new IllegalArgumentException("radius cannot be negative");

        this.radius = radius;
    }

    @Override
    public double area(){
        return PI*radius*radius;
    }

    @Override
    public String describe() {
        return "This is a circle with" + radius + "and area" + area();
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException{
        if (area() < 1) throw new ShapeTooSmallException("area cannot be less than 1");
        else if (area() > canvas.capacity()) throw new ShapeTooLargeException("area cannot be greater than" + canvas.capacity());

        canvas.circle(radius);
    }

}
