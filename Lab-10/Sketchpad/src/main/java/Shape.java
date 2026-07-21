public abstract class Shape {

    public abstract double area();
    public abstract String describe();
    public abstract void draw();

    public void checkFit() throws DrawException {
        double a = area();

        if (a < 1.0) {
            throw new ShapeTooSmallException();
        }



    }
}
