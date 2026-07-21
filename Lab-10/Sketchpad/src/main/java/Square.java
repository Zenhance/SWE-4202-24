public class Square extends Shape{
    public Square(int i) {
        super(i);
    }

    @Override
    public double area() {
        return i*i;
    }

    @Override
    public String describe() {
        return "";
    }

    @Override
    public void draw(Canvas canvas) throws shapeException {

    }
}
