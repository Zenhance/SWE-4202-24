public class ShapeTooLargeException extends ShapeException {
    public ShapeTooLargeException(double area, double capacity) {
        super(String.format("The area %.2f is too large for the which has %.2f capacity", area, capacity));
    }
}
