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
    @Override
    public void setWidth(double newSide)
    {
        super.setWidth(newSide);
        super.setHeight(newSide);
    }
    @Override
    public void setHeight(double newSide)
    {
        super.setHeight(newSide);
        super.setWidth(newSide);
    }
}