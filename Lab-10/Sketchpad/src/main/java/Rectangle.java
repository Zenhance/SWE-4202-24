public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if(width <=0 && height <=0)
            throw new IllegalArgumentException("Width and height can't be negative");
    }

    public void setWidth(double width) {
        if(width<=0) throw new IllegalArgumentException("Width has to be positive");
        this.width = width;
    }

    public void setHeight(double height) {
        if(height<=0) throw new IllegalArgumentException("Height has to be positive");
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public String description() {
        return ("The width of the rectangle is: " + width + "The height of the rectangle is: " + height + "& the area is: " + area());
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        if(area()<1) throw new ShapeTooSmallException ("Impossible");
        else if(area()> canvas.capacity()) throw new IllegalArgumentException("Impossible");
    }


}
