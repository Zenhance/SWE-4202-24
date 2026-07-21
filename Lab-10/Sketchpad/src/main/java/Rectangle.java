public class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("width must be positive");
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("height must be positive");
        this.height = height;
    }
    @Override
    public double area() { return width * height; }

    @Override
    public String describe() { return String.format("Rectangle(%.2f x %.2f, area=%.2f)", width, height, area()); }

    @Override
    public void draw(Canvas canvas) throws ShapeTooLargeException, ShapeTooSmallException {
        double area = area();
        if (area > canvas.capacity()) throw new ShapeTooLargeException(describe() + " too large");
        if (area < 1) throw new ShapeTooSmallException(describe() + " too small");
        canvas.rectangle(width, height);
    }
}