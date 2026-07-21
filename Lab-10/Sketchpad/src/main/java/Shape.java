
public abstract class Shape {

    public abstract double area();

    public String describe() {
        return String.format("Area: %.2f", area());
    }

    public void draw() throws ShapeTooSmallException, ShapeTooLargeException {
        double a = area();
        if(a < 1.0) {
            throw new IllegalArgumentException("Area is too small");
        }

        if(a > capacity()) {
            throw new IllegalArgumentException("Area is too large");
        }

    }
    protected abstract void printOn(Canvas canvas);
}
