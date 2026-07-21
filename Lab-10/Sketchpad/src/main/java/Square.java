public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }

    public double getSide(){
        return getWidth();
    }

    public void setWidth(double width){
        super.setWidth(width);
        super.setHeight(width);
    }

    public void setHeight(double height){
        super.setHeight(height);
        super.setWidth(height);
    }
}
