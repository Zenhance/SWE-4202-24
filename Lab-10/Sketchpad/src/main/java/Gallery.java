import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private final Canvas canvas;
    private  List<Shape> shapes= new ArrayList<>();
    private final List<String> skipReasons=new ArrayList<>();
    private int drawCount=0;

    public Gallery(Canvas canvas){
        if(canvas==null){
            throw new IllegalArgumentException("Canvas cannot be empty");
        }
        this.canvas=canvas;
        this.shapes=new ArrayList<>();

    }
    public void add(Shape shape) {
        if(shape==null){
            throw new IllegalArgumentException("Shape cannot be empty");
        }
        shapes.add(shape);
    }

    public int waiting(){
        return shapes.size();
    }

    public void render(){
        int drawn=0;
        int skipped=0;
        ArrayList<String> report =new ArrayList<>();
        for(Shape shape:shapes){
            try{
                shape.draw(canvas);
                drawn++;
            }
            catch(ShapeDrawException e){
                skipped++;
                report.add(e.getMessage());
            }
        }
        System.out.println("Drawn= "+drawn);
        System.out.println("Skipped= "+skipped);
        for(String r: report){
        System.out.println(r);
        }
        canvas.show();
    }



}
