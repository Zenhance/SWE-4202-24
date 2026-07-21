public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }else {
            this.width = width;
            this.height = height;
        }
    }
    public void draw(Canvas canvas) throws ShapeException {
        if (area() > canvas.capacity())
            throw new ShapeTooLargeException("Shape too large exception");
        if (area() < 1.0)
            throw new ShapeTooSmallException("Shape too small exception");
        canvas.rectangle(width, height);
    }


    public double area() {
        return width * height;
    }

    public String describe() {
        return String.format("Rectangle(%f, %f)", getWidth(), getHeight());
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
