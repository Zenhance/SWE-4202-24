import java.util.ArrayList;

public class Gallery {

    private final Canvas canvas;
    private final ArrayList<Shape> shapes;

    public Gallery(Canvas canvas) {
        if (canvas == null) {
            throw new IllegalArgumentException("Canvas cannot be null");
        }

        this.canvas = canvas;
        this.shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Shape cannot be null");
        }

        shapes.add(shape);
    }

    public int waiting() {
        return shapes.size();
    }

    public void render() {
        canvas.clear();

        int drawn = 0;
        ArrayList<String> skipped = new ArrayList<>();

        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawn++;
            } catch (ShapeException e) {
                skipped.add(shape.describe() + " — " + e.getMessage());
            }
        }
        System.out.println("Drawing report:");
        System.out.println("  Drawn:   " + drawn);
        System.out.println("  Skipped: " + skipped.size());
        if (!skipped.isEmpty()) {
            System.out.println("  Reasons:");

            for (String reason : skipped) {
                System.out.println("    - " + reason);
            }
        }

        System.out.println("\nFinished canvas:");
        canvas.show();
    }
}

// questions-----

/*
1. **The `Shape` class is abstract because it represents the idea of "any shape" rather than a specific drawable object.** It should not be possible to create a generic `Shape` directly, since every actual shape must be a `Circle`, `Rectangle`, or `Square`.

2. **The `Rectangle` class is left concrete because it is a complete, valid shape that can be created and drawn on its own.** It also serves as the parent of `Square`, allowing the square to reuse the rectangle's drawing and area behavior.

3. **I overrode the size-changing method (for example, `setWidth()` and/or `setHeight()`) in `Square` because the inherited implementation would allow the width and height to become different.** The override ensures that whenever one side changes, the other side is updated as well, preserving the rule that a square must always have equal sides.

4. **I deliberately did not override the `draw()` method in `Square` because the `Rectangle` implementation already draws a square correctly when the width and height are equal.** Reusing the inherited method avoids unnecessary code duplication while maintaining the correct behavior.
*/