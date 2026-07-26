import java.util.ArrayList;

public class Gallery {
    private final Canvas canvas;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public double waiting() {
        return shapes.size();
    }

    public void render() {
        int drawn = 0;
        int skipped =0;
        ArrayList<String> skipReasons = new ArrayList<>();


    }
}
