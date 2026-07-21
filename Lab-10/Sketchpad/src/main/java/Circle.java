public class Circle extends Shape {
    private double radius;
    private final double PI=3.14;

    public Circle(int radius){
        if (radius<0) throw new IllegalArgumentException("Invalid radius");
        this.radius=radius;
    }
    @Override
    public double area(){
        return PI*radius*radius;
    }

    @Override
    public String describe() {
        return "This is a circle with" + radius + "and area" + area();
    }

    @Override
    public void render(Canvas canvas)throws ShapeTooLargeException,ShapeTooSmallException{

        canvas.circle(radius);
    }
}


