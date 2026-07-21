import java.util.ArrayList;
public class Gallery {
    private ArrayList<Shape> shapes;
    private ArrayList<String> skipped;
    private Canvas canvas;

    public Gallery(Canvas canvas){
        this.canvas=canvas;
        shapes = new ArrayList<>();
        skipped = new ArrayList<>();
    }

    public void add(Shape shape){
        shapes.add(shape);
    }

    public int waiting(){
        return shapes.size();
    }

    public void render(){
        int draw=0;
        int skippedCount=0;

        for(Shape shape:shapes){
            try{
                shape.draw(canvas);
                draw++;
            }
            catch(ShapeException e){
                skippedCount++;
                skipped.add(shape.describe()+ " --> " + e.getMessage());
            }
        }

        System.out.println("Draw : "+ draw);
        System.out.println("Skipped: "+ skippedCount);
        if(!skipped.isEmpty()){
            System.out.println("Reasons:");
            for(String s:skipped){
                System.out.println(s);
            }
        }
        System.out.println("Canvas");
        canvas.show();
    }
}
