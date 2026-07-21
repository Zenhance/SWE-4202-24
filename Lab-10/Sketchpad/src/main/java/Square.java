public class Square extends Rectangle{

    public Square(int width, int height) {
        super(width, height);
    }

    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }
    public String describe() {
       return super.describe();
    }
}
