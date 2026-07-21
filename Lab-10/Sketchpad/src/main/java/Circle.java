public class Circle extends Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        }
    }

    @Override
    public abstract double area();

    @Override
    public abstract String describe();

    @Override
    public abstract void draw();


}
