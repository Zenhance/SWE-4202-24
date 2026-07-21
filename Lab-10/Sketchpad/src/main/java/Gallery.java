import java.util.ArrayList;

public class Gallery{

    private final Canvas canvas;
    private final ArrayList<Shape> shapes;

    public Gallery(Canvas canvas){
        if(canvas==null){
            throw new IllegalArgumentException("Canvas cannot be null");
        }
        this.canvas=canvas;
        this.shapes= new ArrayList<>();
    }
    public void add(Shape shape){
        if(shape==null){
            throw new IllegalArgumentException("Shape cannot be null");
        }
        shapes.add(shape);
    }
    public int waiting(){
        return shapes.size();
    }
    public void render(){
        canvas.clear();

    int drawn = 0;
    ArrayList<String>skipped = new ArrayList<>();
    for (Shape shape : shapes) {
        try {
            shape.draw(canvas);
            drawn++;
        } catch (ShapeException e) {
            skipped.add(shape.describe() + " — " + e.getMessage());
        }
    }
        System.out.println("Drawing report:");
        System.out.println("  Drawn:   " + drawn);
        System.out.println("  Skipped: " + skipped.size());
        if (!skipped.isEmpty()) {
        System.out.println("  Reasons:");
        for (String reason : skipped) {
            System.out.println("    - " + reason);
        }
    }
   System.out.println("\nFinished canvas:");
        canvas.show();
}
}