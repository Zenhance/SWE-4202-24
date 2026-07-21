import java.util.ArrayList;
public class Gallery {
    private final Canvas canvas;
    private final ArrayList<Shape> shapes;
    public Gallery(Canvas canvas){
        if(canvas == null){
            throw new IllegalArgumentException("Canvas cannot be null.")
        }
        this.canvas = canvas;
        this.shapes = new ArrayList<>();
    }
    public void add(Shape shape){
        if(shape == null){
            throw new IllegalArgumentException("Shape cannot be null.");
        }
        shapes.add(shape);
    }
}
