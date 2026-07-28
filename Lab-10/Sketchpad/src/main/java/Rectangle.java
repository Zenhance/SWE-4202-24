package main.java;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        if(height<0){
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
        if (width<0){
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public void draw(Canvas canvas) throws ShapeTooLargeException, ShapeTooSmallException {
    if(height<1 || width<1){
        throw new ShapeTooSmallException("Shape too small");
    }
    if (area()>canvas.capacity()){
        throw new ShapeTooLargeException("Shape too large");
    }
    canvas.rectangle(width, height);
    }

    @Override
    public String describe() {
        return "The rectangle height is " + height+ " and width is " +width+ " and the area is " +area() ;
    }
}
