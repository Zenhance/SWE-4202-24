public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        if(width==0 || width<0){
            throw new IllegalArgumentException("Width cannot be negative");
        }
        if(height==0 || height<0){
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
        if(calculateArea()> canvas.capacity() ){
            throw new ShapeTooLargeException();
        }else if(calculateArea()< 1){
            throw new ShapeTooSmallException();
        }else{
            canvas.rectangle( width,height);
        }
    }
}
