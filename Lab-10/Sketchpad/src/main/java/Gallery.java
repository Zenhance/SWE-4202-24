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
//1. The class Shape is abstract because it has no drawable form or area formula of its own which means only concrete shapes(circle,rectangle,square) can meaningfully exist.
//2. I left Rectangle concrete because a rectangle is itself a valid, drawable shape, and it also serves as the parent of Square, and a class can be both.
//3. I overrode width/height in Square because Rectangle's versions would let it break the square invariant.
//4. I deliberately did not override the area() in Square because Rectangle's width* height formula already gives the correct square of s when both sides are kept equal.