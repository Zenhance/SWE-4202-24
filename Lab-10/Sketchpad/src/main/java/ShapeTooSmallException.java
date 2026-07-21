// a valid shape that wouldn't cover even one canvas
public class ShapeTooSmallException extends ShapeException{
    public ShapeTooSmallException(String message){
        super(message);
    }
}
