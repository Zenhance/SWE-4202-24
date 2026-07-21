public abstract class Shape{
    public abstract double area();
    public abstract String describe();
    public abstract void draw(Canvas canvas) throws ShapeException;
}