public class Rectangle {

    protected double width;
    protected double height;

    public Rectangle(double width, double height) {

        if (width <= 0 || height <=0 ) {
            throw new IllegalArgumentException("Width and height has to be positive");
        }
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width*height;
    }
}
