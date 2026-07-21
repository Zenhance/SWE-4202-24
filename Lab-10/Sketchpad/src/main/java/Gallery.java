import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private Canvas canvas;
    private List<Shape> shapes;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        this.shapes = new ArrayList<>();
    }
}