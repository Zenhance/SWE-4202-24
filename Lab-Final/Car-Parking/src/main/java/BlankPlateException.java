public class BlankPlateException extends Exception {
    public BlankPlateException() {
        super("Entry slip left blank");
    }

    public BlankPlateException(String message) {
        super(message);
    }
}
