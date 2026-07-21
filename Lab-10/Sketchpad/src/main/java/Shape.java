public abstract class Shape {

    public abstract double area();
    public abstract String describe();
    public abstract void draw(Canvas canvas) throws DrawException;

    public void checkFit(Canvas canvas) throws DrawException {
        double a = area();

        if (a < 1.0) {
            throw new ShapeTooSmallException(describe() + "area is too small");
        }

        if (a > canvas.capacity()) {
            throw new ShapeTooLargeException(describe() + "area exceeds canvas capacity");
        }

    }
}
