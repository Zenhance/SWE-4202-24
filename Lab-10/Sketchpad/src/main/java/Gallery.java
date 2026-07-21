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
        int drawn=0;
        List<String> skippedReasons=new ArrayList<>();
        for (Shape shape:pile){
            try {
                shape.draw(canvas);
                drawn++;

            }catch (Shapedrawexception e){
                skippedReasons.add(shape.describe() + " -> skipped (" + e.getMessage() + ")");
            }

        }    }

    public int waiting() {
        return pile.size();
    }
}
