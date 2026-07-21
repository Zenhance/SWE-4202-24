public class ShapeTooSmallException extends Exception {
    public ShapeTooSmallException() {
        super("Shape too small. area has to be more than 1.");
    }
}
