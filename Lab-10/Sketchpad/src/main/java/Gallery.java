import java.util.ArrayList;

public class Gallery {
    private Canvas c;
    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<String> skipped = new ArrayList<>();


    Gallery(Canvas c){
        this.c=c;
    }

    public void add(Shape s){
        if(s.getWidth() > c.width() || s.getHeight() > c.height() || s.area() > c.capacity()){
            skipped.add(s.toString()+ "was too large");
            throw new ShapeTooLarge("Shape too large!");
        }


        if(s.area() < 1) {
            skipped.add(s.toString()+ "was too large");
            throw new ShapeTooSmall("Shape too small");
        }

        shapes.add(s);
    }

    public String waiting(){
        int count = 1;
        String out = "In waiting:\n";
        for(Shape s: shapes){
            out += (count+". "+s.toString()+"\n");
            count++;
        }

        int skipCount = 1;
        out += "\nSkipped";
        for(String k: skipped){
            out += (skipCount+k+"\n");
            skipCount++;
        }

                return  out;}

    public void render(){
        for(Shape s: shapes){
            System.out.println(s.toString() + " is drawn");
        }
        shapes.clear();
    }
}
