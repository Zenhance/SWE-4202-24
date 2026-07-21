import java.util.ArrayList;
import java.util.List;

public class Gallery {

    private final Canvas canvas;
    private final List<Shape> piles = new ArrayList<>();
    private final List<String> skippedReasons = new ArrayList<>();
    private int drawCount = 0;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape){
        piles.add(shape);
    }

    public int waiting(){
        return piles.size();
    }

    public void render() {
        for (Shape pile : piles) {
            try {
                shape.draw(canvas);
                drawCount++;
            } catch (ShapeDrawException e) {
                skippedReasons.add(e.getMessage());
            }
        }
        report();
        canvas.show();
    }
    private void report(){
        System.out.println("Drawn " + drawCount);
        System.out.println("Skipped " + skippedReasons.size());
        for(String reason : skippedReasons){
            System.out.println(" _ " + reason);
        }
    }
}

