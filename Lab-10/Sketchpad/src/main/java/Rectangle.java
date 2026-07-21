public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if(width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException("width must be greater than zero");
        }
    }

    public void setHeight(double height) {
        if(height <= 0) {
            throw new IllegalArgumentException("height must be greater than zero");
        }
    }

    @Override
    public double area(double width, double height) {
        return width * height;
    }

    @Override
    public void printOn(Canvas canvas) {

    }
}
