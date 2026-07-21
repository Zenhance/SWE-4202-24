public class Circle extends Shape{
    private double radius;

    public Circle (double radius){

        if(radius<0)
            throw new IllegalArgumentException("Radius can't be negative");
        this.radius=radius;
    }
}
