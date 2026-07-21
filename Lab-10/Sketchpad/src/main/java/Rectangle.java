public class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0)
            IllegalArgumentException("Invalid size");
        this.width = width;
        this.height = height;

    }

    public void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException();
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0)
            throw new IllegalArgumentException();
        this.height = height;

    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void raw(Canvas canvas) throws ShapeException {
        if (width < 1 || height < 1) throw new ShapeTooSmallException("Rectangle too small");


        canvas.drawRectangle(width, height);
    }
}
