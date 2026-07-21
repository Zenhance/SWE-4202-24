public class ShapeTooSmallExpection extends ShapeException{
    public ShapeTooSmallExpection(double area) {
        super(String.format("The area %.2f is too small for the canvas.", area));
    }
}
