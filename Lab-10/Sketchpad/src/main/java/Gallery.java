import java.util.ArrayList;

public class Gallery {
    private ArrayList<Shape> shapes= new  ArrayList<>();
    int i=0;
    Canvas canvas;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape) {
        shapes.add(shape);

        if(shapes.get(i).area()>800||shapes.get(i).area()<1) {
            shapes.remove(i);
            i--;
        }
        i++;

    }

    public int waiting() {
        return shapes.size();

    }

    public void render() {
        for (Shape shape : shapes) {

            if(shape instanceof Circle) canvas.circle(((Circle) shape).radius);
            if(shape instanceof Rectangle) canvas.rectangle(((Rectangle) shape).i,((Rectangle) shape).j);
        }
        canvas.show();
    }
}
