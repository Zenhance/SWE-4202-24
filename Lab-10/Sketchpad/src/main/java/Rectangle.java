public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        requirePositive(width);
        requirePositive(height);
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        requirePositive(width);
        this.width = width;
    }
    public void setHeight(double height) {
        requirePositive(height);
        this.height = height;
    }

    @Override
    protected void make(Canvas canvas) {
        canvas.rectangle(width, height);
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String describe(){
        return "Rectangle";}
}
