public class ShapeTooLargeException extends ShapeDrawException{
    public ShapeTooLargeException(Shape shape,Canvas canvas){
        super(String.format("%s exceeds canvas (%d cells)",shape.describe(),canvas.capacity()),shape);
    }
}
