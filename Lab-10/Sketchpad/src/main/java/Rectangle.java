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
    public double getWidth() {
        return width;
    }

    public double getHeight(){
        return height;
    }

    public void setWidth(double width){
        this.width=width;
    }
    public void setWidth(double height){
        this.height=height;
    }
}
