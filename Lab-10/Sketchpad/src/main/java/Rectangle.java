public class Rectangle extends Shape{
    protected double width;
    protected double height;
    public Rectangle(double width,double height){
        if(width<=0 || height <=0){
            throw new IllegalArgumentException("width and height must be greater than 0.");
        }
        this.width=width;
        this.height=height;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
}
