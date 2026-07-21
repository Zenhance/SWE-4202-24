public abstract class Shape {
    public abstract double area();

    protected abstract void paint(Canvas canvas);

    public String describe() {
        return String.format("%s(area = %.2f)", getClass().getSimpleName(), area());
    }

    public final void draw(Canvas canvas) throws ShapeException {
        if (canvas == null) {
            throw new IllegalArgumentException("Canvas cannot be null.");
        }
        double shapeArea = area();
        if (shapeArea < 1.0) {
            throw new ShapeTooSmallException(String.format("Area %.2f is smaller than one canvas cell.", shapeArea));
        }
        if (shapeArea > canvas.capacity()) {
            throw new ShapeTooLargeException(String.format("Area %.2f exceeds canvas capacity %d.", shapeArea, canvas.capacity()));
        }
        paint(canvas);
    }
    protected static void requirePositive(double value, String dimensionName) {
        if (!Double.isFinite(value) || value <= 0) {
            throw new IllegalArgumentException((dimensionName + "must be greater than 0."));
        }
    }
}
