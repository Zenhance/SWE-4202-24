public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        super.setHeight(side);
        super.setWidth(side);
    }
    public void setWidth(double width){
        setSide(width);
    }
    public void setHeight(double height){
        setSide(height);
    }

    @Override
    public String getDescription() {
        return "Square with Side:"+getWidth();
    }
}
