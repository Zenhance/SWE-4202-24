/*
 * ShapeException — common checked superclass for anything that can go wrong when a well-formed shape meets a canvas that can't hold it.
 */
public abstract class ShapeException extends Exception {
        public ShapeException(String message) {
        super(message);
    }
}
