public class Rectangle extends Shape{
    protected double width;
    protected double height;

    public Rectangle(double width, double height){
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width){
        if(width<=0) throw new IllegalArgumentException("width must be +ve ");
        this.width=width;
    }

    public void setHeight(double height){
        if(height<=0) throw new IllegalArgumentException("height must be +ve ");
        this.height=height;
    }
}
