public abstract class Shape{
    public abstract double area();
    public abstract void draw(Canvas canvas)throws ShapeTooLargeException,ShapeTooSmallException, ShapeException;
    public abstract String describe();


}
