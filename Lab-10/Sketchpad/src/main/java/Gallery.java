import java.util.ArrayList;
import java.util.List;

public class Gallery {

        private final Canvas canvas;
        private final List<Shape> pile = new ArrayList<>();

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape) {
        pile.add(shape);
    }

    public void render() {
        int drawn = 0;
        List<String> skippedReasons = new ArrayList<>();
        for (Shape shape : pile) {
            try {
                shape.draw(canvas);
                drawn++;

            } catch (Shapedrawexception e) {
                skippedReasons.add(shape.describe() + " -> skipped (" + e.getMessage() + ")");
            }

        }


        System.out.println("Drew " + drawn + " shape(s), skipped "
                + skippedReasons.size() + " shape(s).");
        for (String reason : skippedReasons) {
            System.out.println("  " + reason);
            canvas.show();
        }
    }

    public int waiting() {
        return pile.size();
    }
}
/*1.Which class is abstract, and why nobody may construct it.
Ans: The Shape class is abstract as a shape can be of many types it is defined as an abstract class

2. Which parent class you left concrete, and why.
Ans:I left the Rectangle parent class as concrete because a rectangle itself is a real shape and it can also
act as a parent class of a square.

3.One method you overrode even though the parent implemented it, and why
Ans: setLength and setWidth methods were overrode in the square class even though the parent
rectangle implemented it.This was done to set the length and width of the square equal.

4.One method you deliberately did not override, and why.
Ans:The area method was not overridden in the square class,this is because the rectangle class
already implements the area which is the product of length and width. Only the length and width
of the circle needs to be changed into a same side which is done by overriding the setWidth
 and setLength method so the area meth doesn't need to be overridden.*/