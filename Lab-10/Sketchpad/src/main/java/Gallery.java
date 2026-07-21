import java.util.ArrayList;
import java.util.List;

public class Gallery {
   private Canvas canvas;
   private final List<Shape> shapes=new ArrayList<>();

   public Gallery(Canvas canvas){
       this.canvas=canvas;
   }
   public void add(Shape shape){
       shapes.add(shape);
   }
   public int waiting(){
       return shapes.size();
   }
   public void render(){
       int drawn=0;
       int skipped = 0;
       String arg="";
       for(Shape shape:shapes){
           try{
               drawn++;
               shape.draw(canvas);
           } catch (ShapeException e) {
               skipped++;
           }

       }


   }

}
