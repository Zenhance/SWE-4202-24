public abstract class Shape {
    public abstract double area();

    protected abstract void paint(Canvas canvas);

    public String describe(){
        return getClass().getSimpleName() + "(area=" + area() +")";
    }

    public void draw(Canvas canvas) throws ShapeException {
        double shapeArea = area();

        if (shapeArea < 1) {
            throw new ShapeTooSmallException(
                    describe() + " will not cover even one cell of canvas"
            );
        }

        if (shapeArea > canvas.capacity()) {
            throw new ShapeTooLargeException(
                    describe() + " exceeds canvas capacity " + canvas.capacity() + "."
            );
        }

        paint(canvas);
    }
}
