public abstract class Shape {
    public abstract double area();
    public abstract String describe();
    protected abstract void render(Canvas canvas);

    public final void draw(Canvas canvas) throws ShapeTooLargeException,ShapeTooSmallException{
        double area=area();
        if(area>canvas.capacity()){
            throw new ShapeTooLargeException(this,canvas);

        }
        if(area<1){
            throw new ShapeTooSmallException(this,canvas);
        }
        render(canvas);
    }
}
