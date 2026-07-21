import java.sql.SQLOutput;
import java.util.ArrayList;
public class Gallery {
    private ArrayList<Shape> shapes=new ArrayList<>();

    public void addShape(Shape s){
        shapes.add(s);
    }

    public void drawAll(Canvas canvas){
        int drawn=0;
        int skipped=0;

        ArrayList<String> reasons=new Arraylist<>();
        for(Shape s: shapes){
            try{
                s.draw(canvas);
                drawn++;
            }
            catch(ShapeException e){
                skipped++;
                reasons.add(s.description()+" : "+e.getMessage());
            }
        }

        System.out.println("Drawn ="+drawn);
        System.out.println("Skipped ="+skipped);

        for(String r: reasons)
            System.out.println(r);
        canvas.show();
    }
}
