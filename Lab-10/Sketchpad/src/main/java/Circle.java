public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        if(radius < 0){
            throw new IllegalArgumentException("Radius must be a positive number");
        }else {
            this.radius = radius;
        }
    }

    public void draw(Canvas canvas) {
        canvas.circle(radius);
    }
    public double area() {
        return 3.14 * radius * radius;
    }

    public String describe(){
        return "Circle(" + radius + ")";
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
