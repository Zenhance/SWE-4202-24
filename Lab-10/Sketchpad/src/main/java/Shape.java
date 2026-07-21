public abstract class Shape {

    public abstract double area();
    public abstract String describe();


    public final void draw(Canvas canvas) throws ShapeException {

        double shapeArea=area();
        if (shapeArea < 1.0) {
            throw new ShapeTooSmallException(
                    describe() + " covers less than one cell"
            );
        }
        if(shapeArea> canvas.capacity()){
            throw new ShapeTooLargeException(
                    describe() + " exceeds canvas capacity " + canvas.capacity()
            );}

            paint(canvas);
        }

        protected abstract void paint(Canvas canvas);

    protected static void requirePositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(
                    name + " must be positive"
            );
        }
    }
    }


