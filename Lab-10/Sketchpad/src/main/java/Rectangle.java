public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String describe() {
        return String.format("Rectangle(width=%.2f, height=%.2f, area=%.2f)", width, height, area());
    }

    @Override
    public void draw(Canvas canvas) throws ShapeDrawException {
        if (area() > canvas.capacity()) {
            throw new ShapeTooLargeException(describe() + " is too large for canvas");
        }
        if (area() < 1.0) {
            throw new ShapeTooSmallException(describe() + " is too small to cover one cell");
        }
        canvas.rectangle(width, height);
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

