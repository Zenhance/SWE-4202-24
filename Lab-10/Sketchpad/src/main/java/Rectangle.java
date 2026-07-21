public class Rectangle extends Shape{
    private final double width;
    private final double height;
    public Rectangle(double width,double height){
        if(width<1 || height <1){
            throw new IllegalArgumentException("Too Smoll");
        }
        this.width=width;
        this.height=height;
    }
   public double getWidth(){
        return width;
   }
    public double getHeight(){
        return Height;
    }
    public double setHeight(double height){
        if(height<1)
            throw new IllegalArgumentException("Invalid");
        this.height=height;
    }
    public double setWidth(double width){
        if(width<1)
            throw new IllegalArgumentException("Invalid");
        this.width=width;
    }
    @Override
    public double area(){
        return width*height;
    }
    @Override
    public String describe(){
        return String.format(Rectangle(width=%.2f,height=%.2f,area=%.2f),width,height,area();
    }
    @Override
    public void draw(Canvas canvas)throws ShapeException{
        double area=area();
        if(area>canvas.capacity()){
            throw new ShapeTooLargeException("Invalid");
        }
        if(area<1)
            throw new ShapeTooSmallException("Invalid");
        canvas.rectangle(width,height);

    }




}