public class ShapeTooSmallException extends ShapeException
{
    public ShapeTooSmallException(String message)
    {
        super("Shape is too small");
    }
}