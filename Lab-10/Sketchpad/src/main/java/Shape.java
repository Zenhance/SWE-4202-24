public abstract class Shape {
    public abstract double area();
    public abstract String description();
    protected abstract void render(Canvas canvas);

    public final void draw(Canvas canvas) throws ShapeTooLargeException,ShapeTooSmallException{
        double area=area();

    }
}
