public class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(double width,double height){
        if(width<= 0 || height<=0){
            throw new IllegalArgumentException("width and height can't be negative");
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
    public void setWidth(double width){
        if(width<=0){
            throw new IllegalArgumentException("width cannot be negative");
        }
        this.width=width;
    }
}
