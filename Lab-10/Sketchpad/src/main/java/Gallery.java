import java.util.ArrayList;
public class Gallery {
    private ArrayList<Shape> shapes=new ArrayList<>();
    public void add(Shape shape){
        shapes.add(shape);
    }

    public void render(Canvas canvas) {
        int drawncount=0;
        int skippedcount=0;
        ArrayList<String> skippedReport =new ArrayList<>();
        for(Shape shape:shapes){
            try{
                shape.draw(canvas);
                drawncount++;
            }
            catch (ShapeDrawException e){
                skippedcount++;
                skippedReport.add(shape.describe());
            }
        }
        System.out.println("===GALLERY REPORT===");
        System.out.println("Shapes drawn: "+drawncount);
        System.out.println("Shapes skipped: "+skippedcount);
        if(!skippedReport.isEmpty()){
            System.out.println("\nSkipped Details:");
            for(String reason:skippedReport ){
                System.out.println("- "+reason);
            }
        }
        System.out.println("\n===CANVAS DISPLAY===");
        canvas.show();
    }
}
