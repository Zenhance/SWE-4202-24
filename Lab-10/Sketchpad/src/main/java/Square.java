public class Square extends Rectangle{

    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        this.width = side;
    }


}
