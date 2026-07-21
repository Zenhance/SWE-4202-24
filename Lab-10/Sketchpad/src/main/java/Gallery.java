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
        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
            } catch (ShapeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
