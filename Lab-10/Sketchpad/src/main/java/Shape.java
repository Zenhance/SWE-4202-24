public abstract class Shape {
    public abstract double area();
    public String description(){
        return "Rectangle";
    }
    public abstract void draw(Canvas canvas){
        throws ShapeException;
    }
}
