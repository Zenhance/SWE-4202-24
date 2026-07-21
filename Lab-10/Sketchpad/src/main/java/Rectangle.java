public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double area() {
        return 0.0;
    }

    @Override
    public String describe() {
        return "Rectangle";
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        // TODO: Implement later
    }
}