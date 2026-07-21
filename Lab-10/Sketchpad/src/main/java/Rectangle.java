public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String describe() {
        return String.format("Rectangle(%f, %f)", getWidth(), getHeight());
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        if (area() > canvas.capacity())
            throw new ShapeTooLargeException("Shape too large exception");
        if (area() < 1.0)
            throw new ShapeTooSmallException("Shape too small exception");
        canvas.rectangle(width, height);
        canvas.show();
    }

    @Override
    public double area() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
