public class Square extends Rectangle {
    public Square(double side){
        super(side, side);
    }
    public double setSide(double side){
        super.setHeight(side);
        super.setWidth(side);
    }
}
