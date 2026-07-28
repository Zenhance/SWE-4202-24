public abstract class Shape {

    public abstract double area();
    public abstract void paint(Canvas canvas);
    public String describe() {
        return String.format("%s with area %.2f", getClass().getSimpleName(), area());
    }
    public void draw(Canvas canvas) throws ShapeException {
        double a = area();
        int capacity = canvas.capacity();

        if (a > capacity) {
            throw new ShapeTooLargeException(this, a, capacity);
        }
        if (a < 1.0) {
            throw new ShapeTooSmallException(this, a);
        }
        paint(canvas);
    }
}
