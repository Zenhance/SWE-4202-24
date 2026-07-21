public class Square extends Rectangle{

    public Square(double width) {
        super(width, width);
    }

    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }
    public String describe() {
       return super.describe();
    }
}
