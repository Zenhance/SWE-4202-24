public abstract class Shape{
    public abstract double area();
    public abstract void draw(Canva canva)throws ShapeTooLargeException,ShapeTooSmallException;


}
