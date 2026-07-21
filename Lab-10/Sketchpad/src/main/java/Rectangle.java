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
    @Override
    public double area(){
        return width*height;
    }
    @Override
    public String describe(){
        return String.format(Rectangle(width=%.2f,height=%.2f,area=%.2f),width,height,area();
    }
    @Override
    public void draw(Canvas canva){

    }




}