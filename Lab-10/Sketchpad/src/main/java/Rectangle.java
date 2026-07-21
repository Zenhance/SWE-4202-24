public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        if( width<=0){
            throw new IllegalArgumentException("Width cannot be negative");
        }
        if(height<=0){
            throw new IllegalArgumentException("Height cannot be negative");
        }

        this.width=width;
        this.height=height;
    }

    @Override
    public double calculateArea(){
        return width*height;
    }

    @Override
    public String describe() {
        return ("Rectangle "+ "Width:"+width + "Height:"+height);
    }

    @Override
    public void draw(Canvas canvas)throws DrawingException{
        double areaOfRectangle=calculateArea();
        if(areaOfRectangle> canvas.capacity() ){
            throw new ShapeTooLargeException("Area is too large");
        }else if(areaOfRectangle< 1){
            throw new ShapeTooSmallException("Area is too small;");
        }else{
            canvas.rectangle( width,height);
        }
    }
}
