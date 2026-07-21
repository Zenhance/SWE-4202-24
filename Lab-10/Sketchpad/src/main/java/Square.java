public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    @Override
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        super.setWidth(height);
        super.setHeight(height);
    }

    @Override
    public String describe() {
        return String.format("Square(side = %.2f, area = %.2f)", getWidth(), area());
    }
}