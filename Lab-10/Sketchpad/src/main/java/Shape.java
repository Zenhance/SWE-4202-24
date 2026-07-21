public class Shape {
    public abstract double area();
    public abstract void draw(Canvas canvas) throws ShapeTooLargeException,ShapeTooSmallException;
}
