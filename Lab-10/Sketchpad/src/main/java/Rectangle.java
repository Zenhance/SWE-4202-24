public class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        if(width <= 0 || height <= 0) {
            throw new IllegalArgumentException(String.format("width and height must be positive: %.1f * %.1f", width,height));
        }
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String describe() {
        return String.format("Rectangale %.1f %.1f", width, height);
    }

    @Override
    public void draw (Canvas canvas) throws ShapeTooLargeException, ShapToolSmallException {
        double area = area();

        if (area > canvas.capacity()){
            throw new ShapeTooLargeException(String.format("Rectangle area is too large %.2f exceeds canvas capacity %d", area,
                    canvas.capacity()));
        }
        if (area < 1.0){
            throw new ShapToolSmallException(
                    String.format("Circle area %.2f is less than canvas capacity (1 cell)", area)
            );
        }
        canvas.rectangle(width,height);
    }

}
