import java.util.ArrayList;

public class Gallery {
    private ArrayList<Shape> shapes;
    private Canvas canvas;
    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        shapes = new ArrayList<>();
    }
    public ArrayList<Shape> getShapes() {
        return shapes;
    }
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
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

/*
1.Which class is abstract, and why nobody may construct it.
ans: Shape class is abstract class. circle , rectangle, square are shape's but shape in and itself is not a shape that can be drawn. so nobody should construct it.

2.Which parent class you left concrete, and why.
ans: I have left rectangle parent class concrete because it be constructed and it is a parent class.

3. One method you overrode even though the parent implemented it, and why.
ans: I have overrode describe method because it describes each shape , so unique implementation is needed.

4. One method you deliberately did not override, and why.
ans: I have not overriden the area method in square because it can use the same method because it can use the same method from rectangle.
 */
