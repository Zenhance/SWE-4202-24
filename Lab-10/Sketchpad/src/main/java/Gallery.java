import java.util.ArrayList;

public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        shapes = new ArrayList<>();
    }

    public void add(Shape s) throws ShapeException {
        if (s.area() > canvas.capacity())
            throw new ShapeTooLargeException("Shape too large exception");
        if (s.area() < 1.0)
            throw new ShapeTooSmallException("Shape too small exception");

        shapes.add(s);
    }

    public int waiting() {
        return shapes.size();
    }

    public void render() {
        for (Shape s : shapes) {
            s.draw(canvas);
        }
    }
}
