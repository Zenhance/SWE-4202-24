public class UnknownPlateException extends Exception {
    public UnknownPlateException() {
        super("Plate not found in the park");
    }

    public UnknownPlateException(String message) {
        super(message);
    }
}
