import java.util.ArrayList;

public class Gallery {
    private ArrayList<Shape> shapes= new  ArrayList<>();
    Canvas canvas;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Shape shape) {
        try {shapes.add(shape);}
        catch(Exception e) {
            if(e instanceof IllegalArgumentException)
            {
                System.out.println("Invalid shape");
            }
            if(e instanceof CheckedExceptions)
            {
                System.out.println("this shape cannot be drawn right now");
            }
        }
    }

    public int waiting() {
        return shapes.size();

    }

    public void render() {
        for (Shape shape : shapes) {
            if(shape instanceof Square) canvas.rectangle(((Square) shape).i,((Square) shape).j);
            if(shape instanceof Circle) canvas.circle(((Circle) shape).radius);
            if(shape instanceof Rectangle) canvas.rectangle(((Rectangle) shape).i,((Rectangle) shape).j);
        }
        canvas.show();
    }
}
