import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private final List<Shape> shapes = new ArrayList<>();
    private final List<String> skippedReasons = new ArrayList<>();
    private int drawnCount = 0;
    private final Canvas canvas;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public int waiting() {
        return shapes.size();

    }

    public void render() {
        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawnCount++;
            } catch (ShapeException e) {
                skippedReasons.add(shape.describe() + " ->" + e.getMessage());
            }
        }
        System.out.println("Drawn:  " + drawnCount);
        System.out.println("Skipped: " + skippedReasons.size());
        for (String reason : skippedReasons) {
            System.out.println(" - " + reason);
        }
        canvas.show();
    }

}
