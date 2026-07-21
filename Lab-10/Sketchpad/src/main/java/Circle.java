 public class Circle extends Shape{
    private final double radius;

    public Circle(double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("Radius must be greater than 0"  + radius);
        }
        this.radius = radius;
    }
    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    @Override
    public String describe(){
        return String.format("Area of circle: %.1f", area());
    }

    @Override
    public void draw(Canvas canvas) throws ShapeTooLargeException, ShapToolSmallException{
        double area = area();

        if (area > canvas.capacity()){
            throw new ShapeTooLargeException(String.format("Circle area is too large %.2f exceeds canvas capacity %d", area,
                    canvas.capacity()
            );
        }
        if (area < 1.0){
            throw new ShapToolSmallException(
                    String.format("Circle area %.2f is less than canvas capacity (1 cell)", area)
            );

            canvas.circle(radius);
        }
    }
 }
