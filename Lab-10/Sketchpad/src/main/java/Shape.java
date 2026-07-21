public abstract class Shape {
    public abstract double area();
    public abstract void draw(Canvas canvas) throws ShapeException;

    public String describe(){
        return String.format("%s (area %.2f)", getClass().getSimpleName(), area());
    }
    //description: abstract class jeta theke circle, rectangle and square concrete class create hbe
    protected void checkFit(Canvas canvas) throws ShapeException{
        if(area()> canvas.capacity()){
            throw new ShapeTooLargeException(String.format("Shape area (%.2f) exceeds canvas capacity (%d)", area(), canvas.capacity()));
        }
        if(area()< 1.0){

            throw new ShapeTooSmallException(String.format("Shape area (%.2f) is too small to cover even one cell", area()));

        }

    }
}
