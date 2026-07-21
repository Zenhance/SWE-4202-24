public class Rectangle extends Shape
{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "width and height must be positive, got " + width + " x " + height);
        }
        this.width = width;
        this.height = height;
    }
    public double getWidth()
    {
        return width;
    }
    public double getHeight()
    {
        return height;
    }
    public void setWidth(double newWidth)
    {
        if(newWidth <= 0)
        {
            throw new IllegalArgumentException("width must be positive, got " + newWidth);
        }
        this.width = newWidth;
    }
    public void setHeight(double newHeight)
    {
        if(newHeight <= 0)
        {
            throw new IllegalArgumentException("height must be positive, got " + newHeight);
        }
        this.height = newHeight;
    }

}