import java.util.ArrayList;
import java.util.List;

public class Gallery {
   private Canvas canvas;
   private final ArrayList<Shape> shapes=new ArrayList<>();

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
               arg += "  skipped " + shape.describe() + " " + e.getMessage() + "\n";
           }

       }
       System.out.println("Drawn:" + drawn + "   Skipped: " + skipped);
       if (skipped > 0) {
           System.out.println("Skipped shapes:");
           System.out.print(arg);
       }
       canvas.show();



   }

}
/*
1.ans: The shape class is abstract. Because shape itself cannot be created. It cannot be constructed because a shape doesnt have any specific attributes like sides or radius.

2.ans: The Rectangle class is left concrete. Even though the rectangle is a parent class and its child class is square. Rectangle itself can be constructed and is a valid shape.

3.ans: I overrrode the setWidth and setHeight method in the square class. Because otherwise according to the parent class only one of the sides would change whereas in the square shape we need to have same sides.

4.ans: I did not override the area method in square class. because In parent class rectangle the area is length*width. Its the same for a sqaure if its height and width are the same.



 */