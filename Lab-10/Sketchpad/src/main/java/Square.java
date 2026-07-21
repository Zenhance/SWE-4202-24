public class Square extends Rectangle{
    public Square(double side) {
        super(side,side);
    }
    @Override
    public void setWidth(double width) {
        if(width <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        this.width = width;
        this.height = width;
    }
    @Override
    public void setHeight(double height) {
        if(height <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
        this.width = height;
        this.height = height;
    }
    @Override
    public String describe() {
        return "Square(side=" + width + ", area=" + area() + ")";
    }
}