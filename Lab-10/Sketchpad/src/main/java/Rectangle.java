public class Rectangle  extends Shape {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        if (width<=0||height<=0) {
            throw IllegalArgumentException("Rectangle must be postive, got " + width + "x" + height);
        }
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        if (width<=0||height<=0) {
            throw IllegalArgumentException("Rectangle width must be positive, got " + width)
        }
        this.width = width;
    }
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Rectangle height must be positive, got " + height);
        }
        this.height = height;
    } //will be overriden in square
    @Override
    public double area() {
        return width * height;
    }
    @Override
    public String describe() {
        return String.format("Rectangle(w=%.2f, h=%.2f, area=%.2f)", width, height, area());
    }
    @Override
    public void draw(Canvas canvas) {
        double area = area();
        if (area > canvas.capacity()) {
            throw new ShapeTooLargeException(describe() + " does not fit in canvas of capacity " + canvas.capacity());
        }
        if (area < 1)
            throw new ShapeTooSmallException(describe() + " is too small to cover even one cell");
        canvas.rectangle(width, height);
    }
}