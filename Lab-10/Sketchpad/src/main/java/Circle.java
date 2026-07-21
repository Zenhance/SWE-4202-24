public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
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
