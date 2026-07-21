import java.util.ArrayList;
import java.util.List;


public class Gallery {
    private final List<Shape> shapes=new ArrayList<>();
    private final List<String> skippedReasons=new ArrayList<>();
    private int drawnCount =0;

    public void add(Shape shape){
        shapes.add(shape);
    }

    public void renderAll(Canvas canvas){

    }

    public void printReport(){
        System.out.println();
    }
}
