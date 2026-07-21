package main.java;

public class Rectangle extends Shape{
    private double height;
    private double width;
    public Rectangle(double height,double width){
        if(height<0 || width<0){
            throw new IllegalArgumentException("height and width cannot be negative");
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

    @Override
    public double area() {
        return height*width;
    }
    public String describe(){
        return "This is a rectangle with height "+height+"and width "+width;
    }
    public void draw(Canvas canvas){

    }
}
