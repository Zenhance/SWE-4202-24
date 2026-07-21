public class Circle extends Shape{
    private final double radius;
    public Circle(double radius){
        requirePositive(radius,"Radius");
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    @Override
    public double area(){
        return Math.PI*radius*radius;
    }

}
