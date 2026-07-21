import java.util.ArrayList;
public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape s) {
        shapes.add(s);
    }

    public int waiting() {
        return shapes.size();
    }

    public void render() {
        int drawn = 0;
        int skipped = 0;
        ArrayList<String> reasons = new ArrayList<>();
        for (Shape s : shapes) {
            try {
                s.draw(canvas);
                drawn++;
            } catch (ShapeException e) {
                skipped++;
                reasons.add(s.description() + " : " + e.getMessage());
            }
        }
        System.out.println("Drawn= " + drawn);
        System.out.println("Skipped= " + skipped);

        for (String r : reasons) {
            System.out.println(r);
        }
        canvas.show();
    }
}