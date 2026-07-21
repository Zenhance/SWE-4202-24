public class Square extends Rectangle{
    public Square(double width) {
        super(width,width);
    }

    @Override
    public double area() {
        return width*width;
    }

    @Override
    public String describe() {
        return "Square";
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void draw(Canvas canvas) throws ShapeException {
        if(area()> canvas.capacity()){
            throw new ShapeTooLargeException();
        }
        if(area()<1){
            throw new ShapeTooSmallException();
        }
    }
}
