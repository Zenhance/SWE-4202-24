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
    public double area() {
        return height * width;
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        double calArea = area();
        if (calArea < 1.0) {
            throw new ShapeTooSmallException("Too small");
        }
        if (calArea > canvas.capacity()) {
            throw new ShapeTooLargeException("Too Large");
        }
        canvas.Square(width, height);
    }

    @Override
    public String describe() {
        return " Rectangle [ Width=" + width + ", Height=" + height + ", Area=" + area() + "]";
    }
}