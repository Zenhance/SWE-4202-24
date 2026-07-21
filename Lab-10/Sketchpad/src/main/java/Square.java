public class Square extends Rectangle {
    private double side;
    public Square(double side) {
        super(side, side);
        this.side = side;
    }

    @Override
    public String describe(){
        return String.format("Square with side %.f", side);
    }
}
