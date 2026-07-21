import java.util.ArrayList;
public class Gallery {
    private ArrayList<Shape> shapes;
    private Canvas canvas;
    public Gallery(Canvas canvas) {
        this.canvas = canvas;
            shapes = new ArrayList<>();
        }
        public void add (Shape shape){
            shapes.add(shape);
        }
        public int waiting(){
            return shapes.size();
        }
        public void render(){
            int drawn = 0;
            int skipped = 0;
            ArrayList<String> skippedShapes = new ArrayList<>();
            for (Shape shape : shapes) {
                try {
                    shape.draw(canvas);
                    drawn++;
                } catch (ShapeDrawException e) {
                    skipped++;
                    skippedShapes.add(shape.describe() + " -> " + e.getMessage());
                }
            }
            System.out.println("Gallery Report");

            System.out.println("-----------------------");

            System.out.println("Drawn   : " + drawn);

            System.out.println("Skipped : " + skipped);

            if (!skippedShapes.isEmpty()) {

                System.out.println("\nSkipped Shapes:");
                for (String s : skippedShapes) {
                    System.out.println(s);
                }
            }
            System.out.println();
            canvas.show();
    }
}
