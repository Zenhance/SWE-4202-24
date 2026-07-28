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
    public void render() {
        int drawn = 0;
        List<String> skipReasons = new ArrayList<>();

        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawn++;
            } catch (ShapeException e) {
                skipReasons.add(shape.describe() + " -- skipped: " + e.getMessage());
            }
        }

        System.out.println(drawn + " drawn, " + skipReasons.size() + " skipped.");
        if (!skipReasons.isEmpty()) {
            System.out.println("Skipped:");
            for (String reason : skipReasons) {
                System.out.println("  - " + reason);
            }
        }
        System.out.println();
        canvas.show();
    }
}
