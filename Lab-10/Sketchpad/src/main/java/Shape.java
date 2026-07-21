public abstract class Shape{
    public abstract double area();
    public abstract void draw(Canvas canva)throws ShapeTooLargeException,ShapeTooSmallException;
    public abstract String describe();


}
