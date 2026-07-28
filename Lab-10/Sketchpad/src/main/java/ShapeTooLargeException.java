public class ShapeTooLargeException extends ShapeException
{
    public ShapeTooLargeException(String message)
    {
        super("Shape is too large");
    }
}