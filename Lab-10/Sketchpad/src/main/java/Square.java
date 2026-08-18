public class Square extends Rectangle{
    public Square(double side){
        super(side,side);
    }
    @Override
    public double setWidth(double width){
        super.setWidth(width);
        super.setHeight(width);
        return width;
    }
    @Override
    public double setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
        return height;
    }
}