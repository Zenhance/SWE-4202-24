public class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0)
           throw new IllegalArgumentException("Invalid size");
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
    public void draw(Canvas canvas) throws ShapeException {
        if (width < 1 || height < 1) throw new ShapeTooSmallException("Rectangle too small");
        if(width*height> canvas.capacity()) throw new ShapeTooLargeException("Rectangle too large");
        canvas.rectangle(width,height);
        canvas.rectangle(width, height);
    }
}
