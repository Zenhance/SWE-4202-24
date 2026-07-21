public abstract class ShapeDrawException extends Exception {
    private final Shape shape;

    protected ShapeDrawException(String message,Shape shape){
        super(message);
        this.shape=shape;
    }
    public Shape getShape(){
        return shape;
    }
}
