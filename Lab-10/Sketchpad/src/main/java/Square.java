public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }
    @Override
    public void setWidth(double side){
        requirePositive(side,"Side");
        super.setWidth(side);
        super.setHeight(side);
    }
    @Override
    public void setHeight(double side){
        requirePositive(side,"Side");
        super.setWidth(side);
        super.setHeight(side);
    }
}
