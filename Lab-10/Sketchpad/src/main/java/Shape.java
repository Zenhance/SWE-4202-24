import java.awt.*;

public abstract class Shape {
    public abstract double area();
    public abstract void paint(Canvas canvas);
    public void draw(Canvas canvas) throws ShapeException{
        double a = area();
        if(a > canvas.capacity()){
            throw new ShapeTooLargeException(a,  canvas.capacity());
        }
        if(a < 1.0){
            throw new ShapeTooSmallExpection(a);
        }
        paint(canvas);
    }
    public abstract String describe();

}
