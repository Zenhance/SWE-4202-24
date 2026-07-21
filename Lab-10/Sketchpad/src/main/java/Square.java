public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }

    public double getSide(){
        return getWidth();
    }

    public void setWidth(double side){
        super.setWidth(side);
        super.setHeight(side);
    }

    public void setHeight(double side){
        super.setHeight(side);
        super.setWidth(side);
    }
}
