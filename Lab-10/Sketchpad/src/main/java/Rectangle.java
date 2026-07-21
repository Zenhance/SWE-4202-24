public class Rectangle {
    private double height;
    private double width;
    public Rectangle(double height,double width){
        if(width<=0){
            throw new IllegalArgumentException("Width must be positive");
        }this.width=width;
        if(height<=0){
            throw new IllegalArgumentException("Height must be positive");
        }this.height=height;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
    public void setHeight(double height){
        if(height<=0){
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height=height;
    }
    public void setWidth(double width){
        if(width<=0){
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width=width;
    }

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public String getDescription() {
        return "Rectangle "+width+" "+height;
    }

    @Override
    public void draw(Canvas canvas) throws ShapeDrawException {
        double canvasArea= canvas.width()*canvas.height();
        if(this.area()<1.0){
            throw new ShapeTooSmallException("Shape area is too small for a cell");
        }
        if(this.area()<canvasArea){
            throw new ShapeTooLargeException("Shape area is too large for a cell");
        }
        canvas.rectangle(width,height);
    }
}
