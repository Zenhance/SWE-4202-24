import java.util.ArrayList;

public class Gallery {
    private ArrayList<Shape> shapes= new  ArrayList<>();
    Canvas canvas;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public boolean waiting() {
        return shapes.isEmpty();

    }

    public void render() {
        for (Shape shape : shapes) {
            if(shape instanceof Square) canvas.rectangle(((Square) shape).i,((Square) shape).j);
            if(shape instanceof Circle) canvas.circle(((Circle) shape).radius);
            if(shape instanceof Rectangle) canvas.rectangle(((Rectangle) shape).i,((Rectangle) shape).j);
        }
    }
}
