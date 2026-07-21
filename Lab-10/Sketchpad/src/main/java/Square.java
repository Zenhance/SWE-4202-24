public class Square extends Rectangle {
    private double length;
    public Square(double length){
        super(length, length);
    }

    @Override
    public String describe() {
        return "This is a square with length "+ length + " and area " + area();
    }

    public void setWidth(int width) {
        this.length = width;

    }
}
