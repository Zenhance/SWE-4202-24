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
    public String getDescription() {
        return "Circle with Radius:"+radius;
    }

    @Override
    public void draw(Canvas canvas) throws ShapeDrawException {
        if(radius<1){
            throw new ShapeTooSmallException("Circle is too small");
        }
        if(radius*2>canvas.width()||radius*2> canvas.height()){
            throw new ShapeTooLargeException("Circle is too large");
        }
        canvas.circle(radius);
    }
}
