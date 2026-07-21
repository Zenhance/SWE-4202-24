public class Rectangle extends Shape{
    Rectangle(double height, double width){
        super(height, width);
    }

    @Override
    public int area(){
        double a = height * width;
        return (int)a;
    }
}
