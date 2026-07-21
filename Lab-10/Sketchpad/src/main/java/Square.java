public class Square extends Rectangle {
    public Square(double width) {
        super(width, width);
    }

    @Override
    public double area() {
        return width * width;
    }

    @Override
    public String describe() {
        return "Square";
    }

    public void setWidth(double width) {
        this.width = width;
    }


}