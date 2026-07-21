import java.awt.*;

public abstract class Shape {
    public abstract double area(double x, double y);
    public abstract double area(double x);
    public abstract String draw(Canvas canvas);
    public abstract String describe();

}
