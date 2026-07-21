public class ShapeTooSmallException extends ShapeDrawException{
    public ShapeTooSmallException(Shape shape,Canvas canvas){
        super(String.format("%s would not cover a single cell",shape.describe()),shape);
    }
}
