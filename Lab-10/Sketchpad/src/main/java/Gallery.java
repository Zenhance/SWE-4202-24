import java.util.ArrayList;
import java.util.List;
public class Gallery {
    private Canvas canvas;
    private List<Shape> shapes;

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
        int drawCount = 0;
        int skipCount = 0;
        List<String> skipReports = new ArrayList<>();

        for (Shape shape : shapes) {
            try {
                Shape.draw(canvas);
                drawCount++;
            } catch (DrawingException e) {
                skipCount++;
            }
        }
    }
}