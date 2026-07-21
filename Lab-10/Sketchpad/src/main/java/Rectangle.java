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
    @Override
    public double area() {
        return width * height;
    }

    public void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("width must be positive");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("height must be positive");
        }
        this.height = height;
    }
    public double getWidth() {return width;}
    public double getHeight() {return height;}

    @Override
    public String describe() {
        return "Rectangle(" + width + ", " + height + ")";
    }
}
