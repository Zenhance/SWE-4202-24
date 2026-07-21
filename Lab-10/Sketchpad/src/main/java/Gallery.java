import java.util.ArrayList;
import java.util.List;

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
        List<String> skipped = new ArrayList<>();
        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
            }
            drawn++;
        }
        catch(ShapeDrawException e){
            skipped.add(shape.describe() + " -> skipped: " + e.getMessage());
        }
    }
    System.out.println("Drawn: "+drawn);
    System.out.println("Skipped: "+skipped.size());

    for(
    String reason :skipped)System.out.println("  - "+reason);
    System.out.println();
    canvas.show();
}
}
