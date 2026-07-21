public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        requirePositive(width,"width");
        requirePositive(height,"height");
        this.width = width;
        this.height = height;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public void setWidth(double width){
        requirePositive((width,"width"));
        this.width = width;
    }
    public void setHeight(double height){
        requirePositive((height,"height"));
        this.height = height;
    }
}
