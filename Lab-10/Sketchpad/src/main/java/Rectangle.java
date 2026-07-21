public class Rectangle extends Shape {
    private double height;
    private double width;
    public Rectangle(double height, double width){
        if(height<=0 || width<=0){
            throw new IllegalArgumentException("Height or Width cannot be zero or less");
        }
        this.height=height;
        this.width=width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        if(height<=0){
            throw new IllegalArgumentException("Height cannot be zero or less");
        }
        this.height = height;
    }

    public void setWidth(double width){
        if(width<=0){
            throw new IllegalArgumentException("Height cannot be zero or less");
        }
        this.width=width;
    }


    @Override
    public double area() {
        return height*width;
    }

    @Override
    public String describe() {
        return String.format("Rectangle(height=%.2f, width=%.2f, area=%.2f)", height, width, area());
    }

    @Override
    protected void paint(Canvas canvas) {
        canvas.rectangle(width, height);

    }
}
