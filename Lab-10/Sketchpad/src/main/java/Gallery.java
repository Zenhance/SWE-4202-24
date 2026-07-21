import java.util.ArrayList;

public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes;
    private ArrayList<String> skipped;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        this.shapes = new ArrayList<>();
        this.skipped = new ArrayList<>();
    }
}
