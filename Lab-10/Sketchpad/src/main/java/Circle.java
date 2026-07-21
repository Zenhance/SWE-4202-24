public class Circle extends Shape{
    private final double radius;
    public Circle(double radius) {
        if (radius <= 0) {
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
        @Override
        public String describe(){
        return String.format("Circle(radius=%.2f,area=%.2f)",radius,area());
        }
        @Override
        public void draw(Canvas canvas) throws ShapeTooLargeException,ShapeTooSmallException{
        double diameter = 2* radius;
        }




    }
