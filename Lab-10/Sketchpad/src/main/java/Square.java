public class Square extends Rectangle {

    public Square(double i) {
        super(i,i);
    }


    public String describe() {
        return "This is a Square with width " +i+"And Area"+this.area();
    }

    public void setWidth(int i) {
        this.i=i;j=i;
    }
}
