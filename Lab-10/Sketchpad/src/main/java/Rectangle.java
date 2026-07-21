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
    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public double area(){
    return length*width;
    }

    public String describe(){
        return String.format("Length %.2f , Width %.2f , area= %.2f",length,width,area());
    }

    public void render(Canvas canvas){
    canvas.rectangle(width,length);
    }
}
