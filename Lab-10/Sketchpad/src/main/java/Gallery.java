import java.util.ArrayList;

public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes;
    private ArrayList<String> skipped;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        this.shapes = new ArrayList<>();
        this.skipped = new ArrayList<>();
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public int waiting() {
        return shapes.size();
    }

    public void render() {
        int drawn = 0;
        skipped.clear();

        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawn++;
            } catch (ShapeException e) {
                skipped.add(shape.describe() + " — " + e.getMessage());
            }
        }
        System.out.println("Drawn: " + drawn);
        System.out.println("Skipped: " + skipped.size());

        for (String reason : skipped) {
            System.out.println("  " + reason);
        }

        System.out.println("\nCanvas:");
        canvas.show();
    }
}
