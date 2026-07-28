public class Square extends Rectangle{
    private double length;
    public Square(double length) {
        super(length, length);
    }

    public void setLength(double length) {
        if(length <=0) throw new IllegalArgumentException("Length can't be negative");
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String description() {
        return ("The length of the rectangle is: " + length + "& the area is: " + area());
    }


}
