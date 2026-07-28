public class Square extends Rectangle
{
    public Square(double width)
    {
        super(width, width);
    }

    @Override
    public String describe()
    {
        return "Square : ("+width+")^2";
    }

    @Override
    public double calculateArea()
    {
        return width*width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }
}