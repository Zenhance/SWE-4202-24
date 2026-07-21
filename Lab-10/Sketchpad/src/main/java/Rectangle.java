public class Rectangle extends Shape{

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <  0 || height < 0) throw new IllegalArgumentException("width or height cannot be negative");

        this.height = height;
        this.width = width;
    }

}
