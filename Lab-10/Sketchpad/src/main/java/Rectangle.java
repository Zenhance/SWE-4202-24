public class Rectangle extends Shape{
    Rectangle(double height, double width){
        super(height, width);
    }

    @Override
    public double area(){
        double a = height * width;
        return a;
    }
}
