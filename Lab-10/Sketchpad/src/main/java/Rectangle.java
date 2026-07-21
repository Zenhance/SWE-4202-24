public class Rectangle extends Shape{
    protected double width;
    protected double height;

    public Rectangle(double width,double height){
        if(width<0 || height<0){
            throw new IllegalArgumentException("These cannot be positive");
        }
        this.width=width;
        this.height=height;
    }

    public void setWidth(double Width){
        if(width<=0){
            throw new IllegalArgumentException("Width cannot be Negative");
        }
        this.width=width;
    }

    public void setHeight(double Height){
        if(height<=0){
            throw new IllegalArgumentException("Height cannot be Negative");
        }
        this.height=height;
    }

    public double area(){
        return width*height;
    }

    public String describe(){
        return "Rectangle + ( width=  " + width +", height= " + height + ", area= " + String.format("%.2f",area()) +")";
    }

    public void draw(Canvas canvas)throws ShapeException{
        check(canvas);
        canvas.rectangle(width,height);
    }
}
