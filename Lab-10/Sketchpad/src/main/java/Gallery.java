import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private Canvas canvas;
    private List<Shape> shapes;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        this.shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        if (shape != null) {
            shapes.add(shape);
        }
    }

    public int waiting() {
        return shapes.size();
    }

    public void render() {
        int drawn = 0;
        List<String> skippedShapes = new ArrayList<>();

        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawn++;
            } catch (ShapeException e) {
                skippedShapes.add(shape.describe() + " -> " + e.getMessage());
            }
        }

        System.out.println("=== GALLERY REPORT ===");
        System.out.println("Shapes Drawn: " + drawn);
        System.out.println("Shapes Skipped: " + skippedShapes.size());
    }
}