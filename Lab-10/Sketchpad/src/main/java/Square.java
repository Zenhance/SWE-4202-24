public class Square extends Rectangle{
    protected double v;

    public Square(double v) {
        super(v,v);


    }

    @Override
    public double area() {
        return i*i;
    }

    @Override
    public String describe() {
        return "Square";
    }

    @Override
    public void draw(Canvas canvas) throws shapeException {
        if(canvas.capacity()<area()){
        throw new ShapeTooSmallException ("too big to draw");
        }
        if(area()<1)
            throw new ShapeTooSmallException("too small to draw");
        }

    public void setWidth(double v) {
        this.v=v;
    }
}
