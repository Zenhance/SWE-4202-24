import java.util.ArrayList;

public class Gallery {
    private final Canvas canvas;
    private final ArrayList<Shape> shapes;

    public Gallery(Canvas canvas) {
        if(canvas == null){
            throw new IllegalArgumentException("Canvas cannot be null");
        }
        this.shapes = new ArrayList<>();
        this.canvas = canvas;
    }

    public void add(Shape shape){
        if(shape == null){
            throw new IllegalArgumentException("Shape cannot be null");
        }
        shapes.add(shape);
    }

    public int waiting(){
        return shapes.size();
    }
    public void render(){
        ArrayList<String> reasons = new ArrayList<String>();
        int drawn=0, skipped=0;
        canvas.clear();

        for(Shape shape: shapes){
            try{
                shape.draw(canvas);
                drawn++;
            }
            catch(ShapeException exception){
                reasons.add(exception.getMessage());
                skipped++;
            }
        }
        System.out.println("Drawn: "+drawn+" Skipped: "+skipped);

        if(!reasons.isEmpty()){
            for(String reason: reasons){
                System.out.println(reason);
            }
        }
        canvas.show();
    }

}
