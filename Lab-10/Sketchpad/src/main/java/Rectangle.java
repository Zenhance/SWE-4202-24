public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle (int width, int height){
        validate(width,"width");
        validate(height,"height");
       this.width=width;
       this.height=height;
    }

    private static void validate(double value,String name){
        if(value<=0){
            throw new IllegalArgumentException("Rectangle must be positive");
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        validate(width,"width");
        this.width = width;
    }

    public void setHeight(double height) {
        validate(height,"height");
        this.height = height;
    }

    public double area(){
        return width*height;
    }

    public String describe(){
        return null;
    }

    public void draw(Canvas canvas) {
        canvas.rectangle(width,height);
    }
}
