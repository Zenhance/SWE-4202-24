import java.util.ArrayList;

public class Gallery {
    protected ArrayList<Shape> shapelist;
    protected Canvas canvas;
    int count =0;
    int skipped =0;



    public Gallery(Canvas canvas) {
        this.canvas =canvas;
        this.shapelist =new ArrayList<>();
    }

    public void add(Shape a){
        shapelist.add(a);
    }

    public void render() {
        for (Shape s:shapelist)
        try {
            s.draw(canvas);
            count++;
        } catch (shapeException e) {
            skipped++;
        }
        System.out.println(count);
        System.out.println(skipped);
        canvas.show();

    }

    public int waiting() {
        return shapelist.size();
    }
}
