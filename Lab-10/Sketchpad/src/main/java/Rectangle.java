public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width,double height) {
        requirePositive(width, "Width");
        requirePositive(height, "Height");

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
        requirePositive(width,"Width");
        this.width = width;
    }

    public void setHeight(double height) {
        requirePositive(height,"Height");
        this.height =height;
    }

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public String describe() {
        return String.format("%s(width=%.2f,height=%.2f,area=%.2f)",getClass().getSimpleName(),width,height,area());
    }

    @Override
    protected void paint(Canvas canvas) {
        canvas.rectangle(width, height);
    }
}