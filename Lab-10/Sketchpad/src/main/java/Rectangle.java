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
    public void setHeight(double height){
        if(height<=0){
            throw new IllegalArgumentException("height cannot be negative");
        }
        this.height=height;
    }
    @Override
    public double area(){
        return height*width;
    }
    @Override
    public void draw(Canvas canvas) throws ShapeTooLargeException,ShapeTooSmallException{
        if(width> canvas.width() || height > canvas.height())
            throw new ShapeTooLargeException("doesn't fit on the canvas");
        if(width <1 || height <1){
            throw new ShapeTooSmallException("is too small to cover a cell");
        }
        canvas.rectangle(width,height);
    }
}
