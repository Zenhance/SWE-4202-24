public abstract class Shape {
    public void draw(Canvas canvas) throws ShapeException{
        if(canvas == null){
            throw new IllegalArgumentException("Argument 'canvas' must not be null.");
        }

        if(area() <= 0){
            throw new ShapeTooSmallException("Shape is too small.");
        }
        if(area()>canvas.capacity()){
            throw new ShapeTooLargeException("Shape is too large.");
        }
        make(canvas);
    }
    public abstract double area();
    protected abstract void make(Canvas canvas);

    protected void requirePositive(double value){
        if(!Double.isFinite(value)||value<0){
            throw new IllegalArgumentException("The value needs to be positive.");
        }
    }

    public abstract String description();
}