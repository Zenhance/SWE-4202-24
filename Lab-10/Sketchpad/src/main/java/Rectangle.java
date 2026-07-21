public class Rectangle extends Shape {
    double i,j;
    public Rectangle(double i, double j) throws ShapeTooLargeException, ShapeTooSmallException {
        super();
        if(i<0||j<0) throw new IllegalArgumentException();
        if(i*j< 1)  throw new ShapeTooSmallException();
        if(i*j>800) throw  new ShapeTooLargeException();
        this.i = i;
        this.j = j;
    }
    @Override
    public double area() {
        return i*j;
    }

    @Override
    public String describe() {
        return "This is a Rectangle with width and height " +i+j +"And Area"+this.area();
    }
}
