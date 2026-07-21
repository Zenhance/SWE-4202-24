public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive ");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (width <= 0) {
            throw new IllegalArgumentException("Height must be positive ");
        }
        this.height = height;
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