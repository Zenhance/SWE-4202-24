public class Rectangle extends Shape {

    protected double width;
    protected double height;

    public Rectangle(double width, double height) {


        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Height and Weight can't be negative");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public String describe() {
        return "Rectangle";
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        if (canvas.capacity() < area()) {
            throw new ShapeTooLargeException("Rectangle is too large");
        }

        if (area() < 1) {
            throw new ShapeTooSmallException("Rectangle is too small");
        }

    }


}
