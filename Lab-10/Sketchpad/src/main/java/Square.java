public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive: " + side);
        }
        super.setWidth(side);
        super.setHeight(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setHeight(double height) {
        setSide(height);
    }

    @Override
    public String describe() {
        return " Square [ Side=" + getWidth() + ", Area =" + area() + "]";
    }
}