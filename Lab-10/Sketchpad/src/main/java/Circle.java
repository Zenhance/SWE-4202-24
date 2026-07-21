public class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Radius must be positive");
        }this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius=radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public String describe() {
        return "Circle with Radius:"+radius;
    }

    @Override
    public abstract void draw(Canvas canvas) throws ShapeDrawException {
         double canvasArea= canvas.width()*canvas.height();
         if(this.area()<1.0){
             throw new ShapeTooSmallException("Shape area ("+area()+") is too small for a cell.");
         }
        if(this.area()>canvasArea){
            throw new ShapeTooLargeException("Shape area ("+area()+") is too large for a cell.");
        }
        canvas.circle(radius);
    }
}
