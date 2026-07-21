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
}
