public class Square extends Rectangle{
    public Square(double side){
        super(side, side);
    }

    @Override
    public void setWidth(double width){
        if (width<=0){
            throw new IllegalArgumentException("Rectangle dimensions must be positive(got " + width+ ")");
        }
        this.width=width;
        this.height=width;
    }

    @Override
    public void setHeight(double height){
        if (height <= 0){
            throw new IllegalArgumentException("Square side must be positive (got "+ height + ")");
        }
        this.width=height;
        this.height=height;

    }
}
