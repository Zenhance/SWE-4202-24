public class Rectangle extends Shape{

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <  0 || height < 0) throw new IllegalArgumentException("width or height cannot be negative");

        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public String describe() {
        return "This is a rectangle with width "+ width + " and height " + height + " and area " + area();
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        if (area() < 1) throw new ShapeTooSmallException("area cannot be less than 1");
        else if (area() > canvas.capacity()) throw new ShapeTooLargeException("area cannot be greater than" + canvas.capacity());

        canvas.rectangle(width, height);
    }

    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }
}
