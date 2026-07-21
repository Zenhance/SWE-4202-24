public class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        if(width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be positive");
        }
        this.width = width;
        this.height = height;
    }
    public double area(double width, double height) {
        return width * height;
    }
}
