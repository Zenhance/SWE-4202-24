public class Rectangle extends Shape{
    private double length;
    private double width;
public Rectangle(double length,double width){
    if (length<=0||width<0){
        throw new IllegalArgumentException("Length or width cannot be negative");
    }
    this.length=length;
    this.width=width;
}

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return length*width;
    }

    @Override
    public String describe() {
        return String.format("Rectangle(Length=%.2f,Width=%.2f,Area=%.2f",length,width,area());
    }

    @Override
    public void draw(Canvas canvas) throws Shapedrawexception {

    }
}
