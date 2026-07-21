public class Circle extends Shape{
    private final double radius;
    public Circle(double radius){
        requirePositive(radius,"Radius");
        this.radius = radius;
    }

}
