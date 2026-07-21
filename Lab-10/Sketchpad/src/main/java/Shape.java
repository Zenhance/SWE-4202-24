public abstract class Shape {
    public  double area;
    public  String describe;
    public abstract void draw(Canvas canvas) throws ShapeTooLargeException, ShapToolSmallException;

}
