public abstract class ShapeException extends Exception {
    private Shape shape;
    protected ShapeException(String message, Shape shape) {
        super(message);
        this.shape = shape;
    }
    public Shape getShape() {
        return shape;
    }
}
