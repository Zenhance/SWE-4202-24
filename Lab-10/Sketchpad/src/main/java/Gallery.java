import javax.swing.*;
import java.util.ArrayList;

public class Gallery {
    private final List<Shape> shapes = new ArrayList<>();
    private final List<String> skippedReasons = new ArrayList<>();
    private int DrawnCount = 0;
    public void add(Shape shape){
        shapes.add(shape);
    }
    public void drawAll(Canvas canvas){
        for(Shape shape : shapes){
            try{
                shape.draw(canvas);
                drawnCount++;
            } catch (ShapeException e){
                skippedReasons.add(shape, describe()+ " ->" + e.getMessage());
            }
        }
    }
    public void report(Canvas canvas){
        System.out.println("Drawn:  "+drawnCount);
        System.out.println("Skipped: "+ skippedReasons.size());
        for(String reason : skippedReasons){
            System.out.println(" - "+ reason);
        }
        canvas.show();
    }

}
