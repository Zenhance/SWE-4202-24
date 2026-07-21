public class Square extends Rectangle{
    Square(double side){
        super(side, side);
    }

    public void setWidth(double d){
        width = d;
        height = d;
    }
}
