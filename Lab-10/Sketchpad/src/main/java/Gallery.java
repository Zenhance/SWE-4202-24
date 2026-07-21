import java.util.ArrayList;

public class Gallery {
    private ArrayList<Shape> shapes;
    private Canvas canvas;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        shapes = new ArrayList<>();
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
        ArrayList<String> failedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawn++;
            }
            catch (ShapeDrawingException e) {
                skipped++;
                failedShapes.add(shape.describe() + " -> " + e.getMessage());
            }
        }
        System.out.println("Drawing report:");
        System.out.println("Drawn: " + drawn);
        System.out.println("Skipped: " + skipped);
        if (skipped > 0) {
            System.out.println("\nSkipped shapes:");
            for (String problem : failedShapes) {
                System.out.println(problem);
            }
        }
        System.out.println("\nCanvas:");
        canvas.show();
    }
 }



/*1.Shape is an abstract class because it represents the common idea of a shape but does not have a specific form, so nobody should be able to create a plain Shape object.
2.Rectangle is a concrete parent class because a rectangle is already a complete drawable shape, while also providing reusable behaviour for its child class Square.
3.Square overrides the setWidth() method inherited from Rectangle because changing only the width would break the rule that a square must always have equal width and height.
4.Square deliberately does not override the area() method because Rectangle already calculates area using width multiplied by height, which is also correct for a square when both values are equal..*/
