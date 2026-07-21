public abstract class Shape {
    public abstract double area();
    public abstract String describe();
    protected abstract void paint(Canvas canvas);



    public void draw(Canvas canva) throws ShapeException {
        double x=area();
        if(x<1){
            throw new ShapeTooSmallException("Area is not enough");
        }
        else if(x> canva.capacity()){
            throw new ShapeTooLargeException("Area is too large");
        }
        paint(canva);
    }


}
