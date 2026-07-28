public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }

    @Override
    public void setWidth(double side){
        if(side<=0) throw new IllegalArgumentException();
        width=side;
        height=side;
    }
    @Override
    public String describe() {
        return "Rectangle(width=" + width + ", height=" + height + ")";
    }
    @Override
    public void setHeight(double side){
        if(side<=0) throw new IllegalArgumentException();

        width=side;
        height=side;

    }
}
