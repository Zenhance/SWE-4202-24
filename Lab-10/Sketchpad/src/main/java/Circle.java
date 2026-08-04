public class Circle extends Shape{
    private double rad;
    public Circle(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Radius must be positive and greater than 0!");
        }rad=radius;}
    @Override
    public double area(){
        return 3.1416*rad*rad;
    }
    @Override
    public String describe(){
        return String.format("Circle(radius=%.1f)",rad);
    }
    @Override
    public void draw(Canvas canvas) throws DrawingException{
        double area=area();
        if(area>canvas.capacity()){
            throw new ShapeTooLargeException("Area can't exceed capacity");
        }
        if((rad+0.5)<1){
            throw new ShapeTooSmallException("Circle is too small");
        }
        canvas.circle(rad);

    }
}
