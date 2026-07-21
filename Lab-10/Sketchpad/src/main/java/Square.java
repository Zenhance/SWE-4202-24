public class Square extends Rectangle {
    private double side;
    public Square(double side){
        super(side, side);
        this.side = side;
    }
    public double setSide(double side){
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public String describe() {
        return "Square " + side +"";
    }
}
