public class Rectangle extends Shape
{
    protected double width;
    protected double height;

    public Rectangle(double width, double height)
    {
        if(width<=0)
            throw new IllegalArgumentException("Width must be positive");
        if(height<=0)
            throw new IllegalArgumentException("Length must be positive");
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea()
    {
        return width*height;
    }

    @Override
    public String describe()
    {
        return "Rectangle : "+width+"*"+height;
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException
    {
        if(calculateArea()>canvas.capacity())
            throw new ShapeTooLargeException("Rectangle is too large");
        if(calculateArea()<1)
            throw new ShapeTooSmallException("Rectangle is too small");

        canvas.rectangle(width,height);
    }

    public void setWidth(double width)
    {
        if(width<=0)
            throw new IllegalArgumentException("Width must be positive");
        this.width = width;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }
}