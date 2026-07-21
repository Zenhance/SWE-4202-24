import java.util.ArrayList;
public class Gallery {
    private final Canvas canvas;
    private final ArrayList<Shape> shapes;
    public Gallery(Canvas canvas){
        if(canvas == null){
            throw new IllegalArgumentException("Canvas cannot be null.");
        }
        this.canvas = canvas;
        this.shapes = new ArrayList<>();
    }
    public void add(Shape shape){
        if(shape == null){
            throw new IllegalArgumentException("Shape cannot be null.");
        }
        shapes.add(shape);
    }
    public int waiting(){
        return shapes.size();
    }
    public void render() {
        int drawnCount = 0;

        ArrayList<Shape> skippedShapes = new ArrayList<>();
        ArrayList<ShapeException> skippedReasons = new ArrayList<>();
        canvas.clear();

        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawnCount++;
            } catch (ShapeException e) {
                skippedShapes.add(shape);
                skippedShapes.add(e);
            }
        }
        System.out.println("Gallery Report:");
        System.out.println(" Drawn: "+drawnCount);
        System.out.println(" Skipped: "+skippedShapes.size());

        if(!skippedShapes.isEmpty()){
            System.out.println(" Reasons:");

            for(int i=0; i < skippedShapes.size(); i++){
                System.out.println("    - "
                        + skippedShapes.get(i).describe()
                        + " -> "
                        + skippedReasons.get(i).getMessage());
            }
        }
        System.out.println("\nFinished Canvas:");
        canvas.show();
    }
}