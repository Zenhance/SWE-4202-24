public class Gallery {
    private final Canvas canvas;
    private final ArrayList<Shape> shapes= new ArrayList<>();
    public Gallery(Canvas canvas){
        this.canvas=canvas;
    }
    public void add(Shape shape){
        shapes.add(shape);
    }
    public int waiting(){
        return shapes.size()
    }
    public void render(){
        int draw=0;
        int skipped=0;
        ArrayList<String>failures=new Arraylist<>();
        for(Shape shape : shapes){
            try{
                shape.draw(canvas);
                draw++;
            } catch (ShapeDrawException e){
                skipped++;
                failures.add(Shape.describe() +"-"+ e.getMessage());
            }
        }
        System.out.println("Drawn:" + drawn);
        System.out.println("Skipped:" + skipped);
        if(!failures.isEmpty()){
            System.out.println("\nSkipped shapes:");
            for(String f : failures){
                System.out.println("-"+ f);
            }
        }
        System.out.println("\nCanvas:");
        canvas.show();
    }
}
