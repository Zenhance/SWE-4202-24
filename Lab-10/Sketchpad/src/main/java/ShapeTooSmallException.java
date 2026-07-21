public class ShapeTooSmallException extends ShapeException{
    public ShapeTooSmallException(String message){
        super("too small for one cell");
    }
}
