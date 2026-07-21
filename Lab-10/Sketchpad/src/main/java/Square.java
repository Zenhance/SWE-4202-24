public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        super.setHeight(width);
    }
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        super.setWidth(height);
    }
}
