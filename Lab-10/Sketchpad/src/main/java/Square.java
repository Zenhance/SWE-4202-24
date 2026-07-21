public class Square extends Rectangle
{
    public Square(double side)
    {
        super(side, side);
    }
    public double getSide()
    {
        return getWidth();
    }
    public void setSide(double newSide)
    {
        setWidth(newSide);
    }
}