import java.util.ArrayList;

public class Gallery {
   private Canvas canvas;
   private ArrayList<Shape> shapes;

   private int drawnCount;
   private int skippedCount;

   public Gallery(Canvas canvas){
       this.canvas=canvas;
       this.shapes = new ArrayList<>();
   }

   public void add(Shape shape){
       shapes.add(shape);
   }

   public int waiting(){
       return shapes.size();
   }

   public void render(){
       for(Shape shape: shapes){
           try {

               shape.draw(canvas);
               drawnCount++;
           } catch (DrawingException e) {
                skippedCount++;

                System.out.println("Skipped: "+shape.describe()+ "| Reason:"+e.getMessage());
           }
       }

       System.out.println();
       System.out.println("Drawn: "+drawnCount);
       System.out.println("Skipped :"+skippedCount);
       System.out.println();


       canvas.show();
   }






}
