import java.util.ArrayList;

public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        shapes = new ArrayList<>();
    }

    public void add(Shape s) {
        shapes.add(s);
    }

    public int waiting() {
        return shapes.size();
    }

    public void render() {
        for (Shape s : shapes) {
            try {
                s.draw(canvas);
            }
            catch (ShapeException e) {
                System.out.println(e.getMessage());
            }
        }

        canvas.show();
    }
}
// Q1.Which class is abstract, and why nobody may construct it?
// Ans: for my case, Shape and ShapeException classes are abstract.
//      a shape without any definition of how it looks should not be
//      constructed and ShapeException is a general exception which
//      should not be called, instead specific exceptions should be called
// Q2. Which parent class you left concrete, and why?
// Ans: Rectangle class was left concrete because a rectangle shape is a
//      valid shape which should be allowed to be created.
// Q3. One method you overrode even though the parent implemented it, and why?
// Ans: the setWidth method was implemented in Rectangle, but it was overridden
//      by Square's setWidth becuase both the width and height should be
//      changed and be equal to eact other.
