public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }
    @Override
    public void setWidth(double side){
        if(side<=0){
            throw new IllegalArgumentException("Side must be greater than 0.");
        }
        this.width=side;
        this.height=side;
    }
    @Override
    public void setHeight(double side){
        if(side<=0){
            throw new IllegalArgumentException("Side must be greater than 0.");
        }
        this.width=side;
        this.height=side;
    }
}
