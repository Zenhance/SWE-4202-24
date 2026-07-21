public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("width must be > 0");
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("height must be > 0");
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String describe() {
        return "Rectangle(width=" + width + ", height=" + height + ")";
    }

    @Override
    public void draw(Canvas canvas) throws ShapeDrawException {

        if (area() < 1) {
            throw new ShapeTooSmallException(describe() + " would cover less than one cell");
        }

        if (area() > canvas.capacity()) {
            throw new ShapeTooLargeException(describe() + " exceeds canvas capacity " + canvas.capacity());
        }

        canvas.rectangle(width, height);
    }
}