public class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius=radius;
    }

    @Override
    public double area(){
        return Math.PI*radius*radius;
    }

    @Override
    public String describe(){
        return "Circle (radius= " + radius + ", area= " + String.format("%.2f",area()) + ")";
    }

    @Override
    public void draw(Canvas canvas)throws ShapeException{
        check(canvas);
        canvas.circle(radius);
    }
}
