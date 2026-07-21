//Question Answer:
/*
1.Shape is abstract because it represents a general concept,not a specific object.
 We should create actual shapes like Circle,Rectangle or Square,not a generic Shape.

2.Rectangle is concrete because it is a complete shape that can be created and drawn.
 Square extends it to reuse its code.

3.Square overrides setWidth()/setHeight() because a square must always have equal sides.
 Changing one side should update the other side too.

4.Square does not override draw() because the Rectangle drawing method already works correctly
 when width and height are equal,avoiding duplicate code.
 */


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

