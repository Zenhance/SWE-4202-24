public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        requirePositive(width,"width");
        requirePositive(height,"height");
        this.width = width;
        this.height = height;
    }

}
