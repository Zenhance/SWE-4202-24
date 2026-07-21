import java.awt.*;
import java.util.ArrayList;

public class Gallery {
    protected Canvas canvas;
    protected ArrayList<Shape> shapes;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        shapes = new ArrayList<>();
    }

    public void add(Shape s) {
        shapes.add(s);
    }

    public int waiting(){
        return shapes.size();
    }

    public void render(){
        int drawn=0;
        int skipped=0;
        for(Shape s: shapes){
            try{
                s.draw(canvas);
                drawn++;
            } catch (ShapeException e) {
                skipped++;
                System.out.println(e.getMessage());

            }
        }
        System.out.println("Drawn: "+drawn);
        System.out.println("Skipped: "+skipped);
        canvas.show();

    }

}
