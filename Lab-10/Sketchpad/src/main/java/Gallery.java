import java.util.*;

public class Gallery {
    private final Canvas canvas;
    private final List<Shape> shapes = new ArrayList<>();

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
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

        ArrayList<String> report = new ArrayList<>();

        for(Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawn++;
            }
            catch(ShapeException e) {
                skipped++;
            }
        }

        System.out.println("Drawn: " + drawn);
        System.out.println("Skipped: " + skipped);

        canvas.show();
    }


}
