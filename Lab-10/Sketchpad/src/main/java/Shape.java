public abstract class Shape {
    public abstract double area();

    public String describe(){
        return String.format("%s [area=%.2f]",getClass().getSimpleName(),area());
    }

    public abstract void draw(Canvas canvas) throws ShapeException;

    protected void check(Canvas canvas)throws ShapeException{
        if(area()>canvas.capacity()){
            throw new ShapeTooLargeException("Area "+area()+ " Exceeds Canvas Capacity " + canvas.capacity());
        }
        if(area()<1){
            throw new ShapeTooSmallException("Area "+ area() +" is less than one cell");
        }
    }
}
