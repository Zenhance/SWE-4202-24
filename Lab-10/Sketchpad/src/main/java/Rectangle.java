public class Rectangle extends Shape{
    Rectangle(double height, double width){
        super(height, width);
    }

    @Override
    public int area(){
        double a = height * width;
        return (int)a;
    }

    public void setWidth(double d){
        width = d;
    }

    public void setHeight(double d){
        height = d;
    }
}
