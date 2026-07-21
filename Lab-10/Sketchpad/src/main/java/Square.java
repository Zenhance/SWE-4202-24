public class Square extends Rectangle {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area(double side) {
        return this.side * side;
    }

    @Override
    public void printOn(Canvas canvas) {

    }
}
