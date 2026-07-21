import java.util.ArrayList;

public class Gallery {
    Canvas c;
    ArrayList<Shape> shapes = new ArrayList<>();


    Gallery(Canvas c){
        this.c=c;
    }

    public void add(Shape s){
        if(s.getWidth() > c.width() || s.getHeight() > c.height() || s.area() > c.capacity())
            throw new ShapeTooLarge("Shape too large!");

        if(s.area() < 1)
            throw new ShapeTooSmall("Shape too small");

        shapes.add(s);
    }

    public String waiting(){return shapes.toString();}

    public void render(){shapes.clear();}
}
