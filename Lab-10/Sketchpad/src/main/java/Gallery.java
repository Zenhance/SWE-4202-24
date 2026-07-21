import java.util.ArrayList;

public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        this.shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public int waiting() {
        return shapes.size();
    }

    public void render() {
        int drawn = 0;
        int skipped = 0;
        ArrayList<String> reasons = new ArrayList<>();

        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawn++;
            } catch (ShapeDrawException e) {
                skipped++;
                reasons.add(e.getMessage());
            }
        }

        System.out.println("\nReport:");
        System.out.println("  Drawn: " + drawn);
        System.out.println("  Skipped: " + skipped);
        for (String reason : reasons) {
            System.out.println("    - " + reason);
        }

        canvas.show();
    }
}