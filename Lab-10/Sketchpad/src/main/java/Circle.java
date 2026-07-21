public class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius=radius;
    }
    @Override
    public double area(){
        return Math.PI*radius*radius;
    }
    @Override
    public String describe(){
        return "Circle(Radius="+radius+",Area="+area()+")";
    }
    @Override
    public void draw(Canvas canvas){
        if(area()>canvas.capacity()){
            throw new ShapeTooLargeException("Circle is too large for the canvas.");
        }
        if(area()<1){
            throw new ShapeTooSmallException("Circle is too small to cover one cell.");
        }
        canvas.circle(radius);
    }
}
