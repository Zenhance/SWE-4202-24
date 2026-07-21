public class Rectangle extends Shape{
    protected double width;
    protected double height;
    public Rectangle(double width,double height){
        if (width <= 0 || height <= 0){
            throw new IllegalArgumentException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
    }
    public void setWidth(double width) {
        if(width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }
    public void setHeight(double height) {
        if(height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
    }
    @Override
    public double area() {
        return width * height;
    }
    @Override
    public String describe() {
        return "Rectangle(width=" + width + ", height=" + height + ", area=" + area() + ")";
    }
    @Override
    public void draw(Canvas canvas) throws ShapeDrawingException {
        if(area() < 1) {
            throw new ShapeTooSmallException("Rectangle area is smaller than one cell");
        }
        if(area() > canvas.capacity()) {
            throw new ShapeTooLargeException("Rectangle area is larger than canvas capacity");
        }
        canvas.rectangle(width,height);
    }
}