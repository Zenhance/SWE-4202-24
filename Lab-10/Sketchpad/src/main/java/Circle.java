public class Circle extends Shape{
        private double radius;

        public Circle(double radius) {
            if (radius < 0)
                throw new IllegalArgumentException("Radius cannot be negative");
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return 3.14 * radius * radius;
        }

        @Override
        public String describe() {
            return String.format("Circle With Radius of (%.2f) unit", getRadius());
        }

        @Override
        public void draw(Canvas canvas) throws ShapeException {
            if (area() > canvas.capacity())
                throw new ShapeTooLargeException("Shape too large exception");
            if (area() < 1.0)
                throw new ShapeTooSmallException("Shape too small exception");
            canvas.circle(radius);
        }
}
