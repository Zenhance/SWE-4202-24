public abstract class Shape {
    public abstract double area();
    public abstract void draw(Canvas canvas) throws ShapeTooLargeException,ShapeTooSmallException;
    public String describe(){
        return String.format("%s (area=%.2f)",getClass().getSimpleName(),area());
    }
}
