public class Circle extends Shape {
        private double radius;
        public Circle(double radius){
            if (radius<=0){
                throw new  IllegalArgumentException("Radius cannot be negative");
            }
            this.radius=radius;
        }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public String describe() {
        return String.format("Circle(radius=%.2f,area=%.2f)",radius,area());
    }

    @Override
    public void draw(Canvas canvas) throws Shapedrawexception {
if (area()> canvas.capacity()){
    throw new Shapetoolargeexception("Circle is too large for a canvas of capacity "+canvas.capacity());
}
if (area()<1){
    throw new Shapetoosmallexception("Circle would not cover even one cell");
}
canvas.circle(radius);
    }
}
