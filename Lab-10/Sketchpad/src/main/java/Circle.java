public class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        if(radius<=0 ){
            throw new IllegalArgumentException("Radius cannot be negative or zero");
        }
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea(){
       return 3.1416*radius*radius;

    }

    @Override
    public String describe(){
        return ("Circle."+ "radius:"+radius);
    }

    @Override
    public void draw(Canvas canvas) throws DrawingException{
        double areaOfCircle=calculateArea();
        if(areaOfCircle>canvas.capacity()){
            throw new ShapeTooLargeException("Area is too big");
        }else if(areaOfCircle<1){
            throw new ShapeTooSmallException("Area is too small");
        }else{
            canvas.circle(radius);
        }

    }



}
