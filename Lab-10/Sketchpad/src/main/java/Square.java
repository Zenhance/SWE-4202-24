public class Square extends Rectangle{
    private double length;
    public Square(double length) {
        super(length, length);
    }
    @Override
    public void setHeight(double length) {
     super.setHeight(length);
     super.setWidth(length);
    }

    @Override
    public void setWidth(double length){
        super.setWidth(length);
        super.setHeight(length);
    }
    @Override
    public String describe() {
        return String.format("Square(side=%.2f, area=%.2f)", length, area());
    }


}
