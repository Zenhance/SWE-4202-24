public class Circle extends Shape{
    Circle(double radius){
        super(radius, radius);
    }

    @Override
    public int area(){
        double a = 3.1416 * height * width;
        return (int)a;
    }

}
