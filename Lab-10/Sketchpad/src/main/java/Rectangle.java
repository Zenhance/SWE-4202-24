public class Rectangle extends Shape
{
    private double width;
    private double height;

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
        if(calculateArea()> canvas.capacity())
            throw new ShapeTooLargeException("Rectangle is too large");
        if(calculateArea()<1)
            throw new ShapeTooSmallException("Rectangle is too small");

        canvas.rectangle(width,height);
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        if(width<=0)
            throw new IllegalArgumentException("Width must be positive");
        this.width = width;
    }

    public double getHeight()
    {
        if(height<=0)
            throw new IllegalArgumentException("Height must be positive");
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }
}