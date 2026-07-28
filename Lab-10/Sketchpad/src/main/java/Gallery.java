package main.java;
import java.util.ArrayList;

public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Gallery(Canvas canvas){
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
        int skipped = 0;
        ArrayList<String> report = new ArrayList<>();
        for (Shape shape : shapes){
            try {
                shape.draw(canvas);
                drawn++;
            }
            catch(ShapeException e){
                skipped++;
                report.add(e.getMessage());
            }
        }
        System.out.println("Drawn shape = " + drawn);
        System.out.println("Skipped shape = "+ skipped);
        canvas.show();

    }
}
