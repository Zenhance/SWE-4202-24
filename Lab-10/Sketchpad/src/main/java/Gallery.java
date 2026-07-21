import java.util.ArrayList;

public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        shapes = new ArrayList<>();
    }

    public void add(Shape s) {
        if (s.area() < canvas.capacity() && s.area() >= 1.0)
            shapes.add(s);
    }

    public int waiting() {
        return shapes.size();
    }

    public void render() {

    }
}
