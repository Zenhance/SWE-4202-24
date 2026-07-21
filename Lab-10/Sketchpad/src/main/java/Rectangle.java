public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height of rectangle must be greater than zero.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area(){
        return height * width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException(
                    "Rectangle width must be greater than zero."
            );
        }

        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException(
                    "Rectangle height must be greater than zero."
            );
        }

        this.height = height;
    }

    @Override
    protected void paint(Canvas canvas) {
        canvas.rectangle(width, height);
    }
}
