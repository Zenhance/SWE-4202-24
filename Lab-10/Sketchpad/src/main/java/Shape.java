public abstract class Shape
{
    public abstract double area;
    public abstract void draw(Canvas canvas) throws ShapeDwawException;
    public String describe()
    {
        return String.format("%s with area %.2f", getClass().getSimpleName(), area());
    }

}
