public class Rectangle extends Shape{

    public Rectangle(int i,int j) {
        super(i, j);
    }

    @Override
    public double area() {
        return i*j;
    }

    @Override
    public String describe() {
        return "Rectangle";
    }


    @Override
    public void draw(Canvas canvas) throws shapeException{
        if(canvas.capacity()<area()){
            throw new ShapeTooSmallException ("too big to draw");
        }
        if(area()<1)
            throw new ShapeTooSmallException("too small to draw");

    }
}
