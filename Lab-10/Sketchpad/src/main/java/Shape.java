public abstract class Shape {

    public abstract double area();

    public String describe() {
        return String.format("Area: %.2f", area());
    }

    public final void draw(Canvas canvas) throws ShapeTooSmallException, ShapeTooLargeException {
        double a = area();

        if(a < 1.0) {
            throw new ShapeTooSmallException(
                    describe() + " - area " + String.format("%.2f", a) + " would not cover even one cell ");
        }

        if(a > canvas.capacity()) {
            throw new ShapeTooLargeException(
                    describe() + " - area " + String.format("%.2f", a) + " exceeds canvas capacity of " +
            canvas.capacity() + " cells");
        }

        printOn(canvas);
    }

    protected abstract void printOn(Canvas canvas);
}
