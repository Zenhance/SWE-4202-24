import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private Canvas canvas;
    private List<Shape> shapes = new ArrayList<>();

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }
    public void add(Shape shape) {
        shapes.add(shape);
    }
    public int waiting() {
        return shapes.size();
    }
}
