public class ShapeTooSmallException extends ShapeException{
    public ShapeTooSmallException(Shape shape, double area) {
        super(String.format(
                        "%s has area %.2f, smaller than a single cell",
                        shape.getClass().getSimpleName(), area),
                shape);
    }
}
