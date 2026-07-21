public class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        if(radius <= 0){
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }
    @Override
    public double area(){
        return Math.PI * radius * radius;
    }
    @Override
    public String describe(){
        return "Circle(radius=" + radius + ", area=" + area() + ")";
    }
    @Override
    public void draw(Canvas canvas) throws ShapeDrawingException{
        if(area() < 1){
            throw new ShapeTooSmallException("Circle area is smaller than one cell");
        }
        if(area() > canvas.capacity()){
            throw new ShapeTooLargeException("Circle area is larger than canvas capacity");
        }
        canvas.circle(radius);
    }
}