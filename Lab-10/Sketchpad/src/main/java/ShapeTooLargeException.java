public class ShapeTooLargeException extends Exception {
    public ShapeTooLargeException() {
        super("Shape too large. area bigger than canvas.");
    }
}
