import java.util.ArrayList;

public class Gallery {
    private Canvas c;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<Shape> skipped = new ArrayList<>();
    private ArrayList<Shape> waiting  =new ArrayList<>();
    private ArrayList<String> reasons  =new ArrayList<>();


    Gallery(Canvas c){
        this.c=c;
    }

    private void draw(Shape s){
        if(s.getWidth() > c.width() || s.getHeight() > c.height() || s.area() > c.capacity()){
            throw new ShapeTooLarge("Shape too large!");
        }


        if(s.area() < 1) {
            throw new ShapeTooSmall("Shape too small!");
        }

    }

    public void add(Shape s){

        shapes.add(s);
        try{
            draw(s);
            waiting.add(s);
        }
        catch (Exception e){
            skipped.add(s);
            reasons.add(e.getMessage());
        }
    }

    public String waiting(){
        int count = 1;
        String out = "";

        for(Shape s: shapes){
            out += (count+". "+s.toString()+"\n");
            count++;
        }
        return out;
    }

    public void render(){

        int count = 1;
        String out = "Is drawn:\n";
        for(Shape s: waiting){
            out += (count+". "+s.toString()+"\n");
            count++;
        }

        int skipCount = 1;
        out += "\nSkipped:\n";
        for(int i=0; i < skipped.size(); i++){
            Shape k = skipped.get(i);
            out += (skipCount+". "+k.toString());
            out += (" ("+ reasons.get(i) +")\n");
            skipCount++;
        }
        System.out.println(out);

        shapes.clear();
    }
}
