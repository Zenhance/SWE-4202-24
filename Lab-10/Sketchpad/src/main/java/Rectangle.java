public abstract class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width,double height){

        if(width<0) throw new IllegalArgumentException("Width is not valid");

        if(height<0) throw new IllegalArgumentException("Height is not valid");
    }

}
