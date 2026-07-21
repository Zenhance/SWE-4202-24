public class Square extends Rectangle{

    public Square(double side){
        super(side,side);
    }
   public double getSide(){
        return getWidth();
   }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }


}
