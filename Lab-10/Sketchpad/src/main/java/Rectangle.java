public class Rectangle extends Shape{
    private double width;
    private double height;
    private static void requirePositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(
                    "Rectangle " + name + " must be positive, got " + value);
        }
    }
    public Rectangle(double width, double height){
        requirePositive(width, "width");
        requirePositive(height, "height");
        this.width=width;
        this.height=height;
    }
}
