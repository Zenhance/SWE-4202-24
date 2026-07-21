public class Circle extends Shape{
    Circle(double radius){
        super(radius, radius);
    }

    @Override
    public double area(){
        double a = 3.1416 * height * width;
        return a;
    }

    @Override
    public String describe(){
        return "Radius: "+height;
    }
}
