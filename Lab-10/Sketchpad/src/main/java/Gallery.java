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
    }

    public boolean waiting() {
        return true;
    }
}
