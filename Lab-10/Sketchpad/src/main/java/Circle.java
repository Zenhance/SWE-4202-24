public class Circle extends Shape {
    double radius;
    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public String describe() {
        return "This is a Circle with radius " + radius+"And Area"+this.area();
    }

    public Circle(double i) throws ShapeTooSmallException, ShapeTooLargeException {
        super();
        if(i<0) throw new IllegalArgumentException();
        if(i*i*Math.PI< 1)  throw new ShapeTooSmallException();
        if(i*i*Math.PI>800) throw  new ShapeTooLargeException();
        this.radius = i;
    }
}
