import java.util.ArrayList;
import java.util.List;

public class Gallery {

    private final Canvas canvas;
    private final List<Shape> waitingList = new ArrayList<>();

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape) {
        waitingList.add(shape);
    }

    public int waiting() {
        return waitingList.size();
    }

    public void render() {
        int drawnCount = 0;
        int skippedCount = 0;
        List<String> reportLogs = new ArrayList<>();

        for (Shape shape : waitingList) {
            try {
                shape.draw(canvas);
                drawnCount++;
            } catch (ShapeException e) {
                skippedCount++;
                reportLogs.add(shape.describe() + " -> " + e.getMessage());
            }
        }

        System.out.println("Render Summary:");
        System.out.println("  Drawn:   " + drawnCount);
        System.out.println("  Skipped: " + skippedCount);
        if (!reportLogs.isEmpty()) {
            System.out.println("  Skipped Details:");
            for (String log : reportLogs) {
                System.out.println("    * " + log);
            }
        }
        System.out.println();

        canvas.show();
    }
}