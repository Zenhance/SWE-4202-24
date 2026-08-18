public abstract class Shape
{
    public abstract double area();
    public abstract void draw(Canvas canvas) throws ShapeDrawException;
    public String describe()
    {
        return String.format("%s with area %.2f", getClass().getSimpleName(), area());
    }
    protected void checkFits(Canvas canvas) throws ShapeDrawException
    {
        double area = area();
        if(area < 1.0)
        {
            throw new ShapeTooSmallException(
                    describe() + " would not cover even one cell");
        }
        if (area > canvas.capacity())
        {
            throw new ShapeTooLargeException(
                    describe() + " exceeds the canvas capacity of " + canvas.capacity());
        }
    }
}