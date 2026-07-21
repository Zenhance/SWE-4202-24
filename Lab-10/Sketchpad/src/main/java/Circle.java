public class Circle extends Shape{
    private final double radius;
    public Circle(double radius){
        if(radius<=0)
            throw new IllegalArgumentException("Radius is too smoll");
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }

    @Override
    public double area(){
        return Math.PI*radius*radius;
    }
    @Override
    public String describe(){
        return String.format(Circle(radius=%.2f,area=%.2f),radius,area();
    }
    @Override
    public void draw(Canvas canvas)throws ShapeException{
        double area=area();
        if(area>canvas.capacity)
            throw new ShapeTooLargeException("Invalid");
        if(area<1)
            throw new ShapeTooSmallException("Invalid");
        canva.circle(radius);
    }





}