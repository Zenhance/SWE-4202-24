public class Circle extends Shape {
    private double radius;

    public Circle(double radius){

        this.radius=radius;


    }

    @Override
    public double area(){
        return 0.0;
    }
    @Override
    public String describe(){
        return "Circle";
    }
    @Override
    public void draw(Canvas canvas)

            throws ShapeException {
    }


}