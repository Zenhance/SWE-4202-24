public class Square extends Rectangle{
    Square(double side){
        super(side, side);
    }

    @Override
    public void setWidth(double d){
        width = d;
        height = d;
    }

    @Override
    public void setHeight(double d){
        width = d;
        height = d;
    }
}
