public abstract class Shape
{
    public abstract double calculateArea();
    public abstract String describe();
    public abstract void draw(Canvas canvas) throws ShapeException;
}