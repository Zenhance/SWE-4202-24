public abstract class Shape {
    public abstract double area();
    public abstract String description();
    public abstract void draw(Canvas canvas) {
        throws ShapeException;
    }
}
