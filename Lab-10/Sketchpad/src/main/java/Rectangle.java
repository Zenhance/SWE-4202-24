public class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        if(width <= 0 || height <= 0) {
            throw new IllegalArgumentException(String.format("width and height must be positive: %.1f * %.1f", width,height));
        }
        this.width = width;
        this.height = height;
    }

}
