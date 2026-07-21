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
