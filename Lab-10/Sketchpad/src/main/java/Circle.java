public class Circle extends Shape{
    private double radius;
    private final double PI = 3.1416;

    public Circle(double radius){
        if (radius < 0) throw new IllegalArgumentException("radius cannot be negative");

        this.radius = radius;
    }

    @Override
    public double area(){
        return PI*radius*radius;
    }

    @Override
    public String describe() {
        return "This is a circle with" + radius + "and area" + area();
    }

}
