public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }else {
            this.width = width;
            this.height = height;
        }
    }
    public void draw(Canvas canvas) {
        canvas.rectangle(width,height);
    }

    public double area() {
        return width * height;
    }

    public String describe() {
        return "Rectangle(" + width + ", " + height + ")";
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
