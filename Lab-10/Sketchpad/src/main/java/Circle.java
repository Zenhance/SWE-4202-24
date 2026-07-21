public class Circle extends Shape {
    public Circle(double R){
        super(R);

    }
    @Override
    public double area() {
        return Math.PI*R*R;
    }

    @Override
    public String describe() {
        return "Circle";
    }

    @Override
    public void draw(Canvas canvas) throws shapeException {
        if(canvas.capacity()<area()){
            throw new ShapeTooSmallException ("too big to draw");
        }
        if(area()<1)
            throw new ShapeTooSmallException("too small to draw");

    }

}
