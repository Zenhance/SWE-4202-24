public class Circle extends Shape{
    private final double radius;
    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("radius cannot be negative");
        }
        this.radius = radius;
    }
        public double getRadius(){
            return radius;
        }
        @Override
        public double area(){
        return Math.PI*radius*radius;
        }




    }
