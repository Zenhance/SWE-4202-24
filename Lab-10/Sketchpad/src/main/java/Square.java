public class Square extends Rectangle{
    Square(double side){
        super(side, side);
    }

    @Override
    public String describe(){
        return "Area: "+area();
    }

    public void setWidth(double d){
        width = d;
        height = d;
    }
}
