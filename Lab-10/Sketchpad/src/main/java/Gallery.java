import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private final Canvas canvas;
    private final List<Shape> shapes = new ArrayList<>();

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }
}