public class Rectangle extends Shape {

    private double width;
    private double height;


    public Rectangle(double width, double height){
        requirePositive(width,"Width");
        requirePositive(height,"Height");

        this.width = width;
        this.height=height;

    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        requirePositive(height,"Height");
        this.height = height;
    }

    public void setWidth(double width) {
        requirePositive(width,"Width");
        this.width = width;
    }
    @Override
    public double area(){
        return width*height;
    }
    @Override
    public String describe(){

        return getClass().getSimpleName() + "(width=" + width + ", height=" + height + ", area=" + area() + ")";

    }
    @Override
    protected void paint(Canvas canvas) {
        canvas.rectangle(width, height);
    }
}
