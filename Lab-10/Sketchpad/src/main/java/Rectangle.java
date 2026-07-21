public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if(width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Rectangle width and height must be positive, got " + width + "x" + height);
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
        if(width <= 0) {
            throw new IllegalArgumentException("Rectangle width must be positive, got " + width);
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if(height <= 0) {
            throw new IllegalArgumentException("Rectangle height must be positive, got " + height);
        }
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void printOn(Canvas canvas) {
        canvas.rectangle(width, height);
    }
}
