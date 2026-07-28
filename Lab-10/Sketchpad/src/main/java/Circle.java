public class Circle extends Shape
{
    private double radius;
    private static final double PI = 3.1416;

    public Circle(double radius)
    {
        if(radius<=0)
            throw new IllegalArgumentException("Radius must be positive");
        this.radius = radius;
    }

    @Override
    public double calculateArea()
    {
        return PI*radius*radius;
    }

    @Override
    public String describe()
    {
        return "Circle : "+PI+"*("+radius+")^2";
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException
    {
        if(calculateArea()>canvas.capacity())
            throw new ShapeTooLargeException("Circle is too large");
        if(calculateArea()<1)
            throw new ShapeTooSmallException("Circle is too small");
        canvas.circle(radius);
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        if(radius<=0)
            throw new IllegalArgumentException("Radius must be positive");
        this.radius = radius;
    }
}