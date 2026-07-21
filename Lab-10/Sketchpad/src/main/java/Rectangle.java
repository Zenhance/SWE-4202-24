public class Rectangle extends Shape{
    protected double length;
    protected double  width;
    public Rectangle(double length, double width){
        if(width<=0){
            throw new IllegalArgumentException("Invalid Width");
        }
        if(length<=0){
            throw new IllegalArgumentException("Invalid length");
        }
        this.length=length;
        this.width=width;

    }
    public void setLength(double newL){
        length=newL;
    }
    public void setWidth(double newW){
         width= newW;
    }
    public void resize(double newW, double newL){
        this.width=newW;
        this.length=newL;
    }
    public double area(){
    return length*width;
    }
    @Override
    public String describe(){
        return String.format("Length %.2f , Width %.2f , area= %.2f",length,width,area());
    }
    @Override
    public void render(Canvas canvas){
    canvas.rectangle(width,length);
    }
}
