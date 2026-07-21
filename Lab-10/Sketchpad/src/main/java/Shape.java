public abstract class Shape {

    public abstract double area();

    public String describe(){
        return String.format("%s Area of: %.2f", getClass().getSimpleName(), area());
    }

    public final void draw(Canvas canvas) throws ShapeException{
        double shapeArea = area();

        if(shapeArea < 1.0){
            throw new ShapeTooSmallException(
                    describe() + " less than one cell"
            );
        }
        if(shapeArea > canvas.capacity()){
            throw new ShapeTooLargestException(
                    describe() + " too large"
            );
        }

        paint(canvas);
    }

    protected abstract void paint(Canvas canvas);

    protected static void requirePositive(double value, String name){
        if(value <= 0 || !Double.isFinite(value)){
            throw new IllegalArgumentException(
                    name + "must be a positive number"
            );
        }
    }


}