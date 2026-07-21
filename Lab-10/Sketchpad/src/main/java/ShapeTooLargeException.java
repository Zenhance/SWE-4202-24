public class ShapeTooLargeException extends ShapeException{
    public ShapeTooLargeException(Shape shape, double area, int capacity){
        super(String.format("%s needs %.2f cells but the canvas only holds %d",
                        shape.getClass().getSimpleName(), area, capacity), shape);
    }
}
