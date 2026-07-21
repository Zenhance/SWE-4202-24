public abstract class Shape {

    public abstract double area();

    public abstract void draw(Canvas canvas) throws ShapeException;


    public String describe() {
        return "Area of the shape" + area();
    }
}