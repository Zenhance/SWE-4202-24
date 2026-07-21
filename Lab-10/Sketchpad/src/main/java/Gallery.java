import java.util.List;
import java.util.ArrayList;
public class Gallery {
    protected Canvas canvas;
    protected List<Shape> shapes;

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
        shapes = new ArrayList<>();
    }

    public void add(Shape s) {
        shapes.add(s);
    }

    public int waiting(){
        return shapes.size();
    }

    public void render(){
        int drawn=0;
        int skipped=0;
        ArrayList<String> skip=new ArrayList<>();
        for(Shape s: shapes){
            try{
                s.draw(canvas);
                drawn++;
            } catch (ShapeException e) {
                skipped++;
                skip.add(e.getMessage());
            }
        }
        System.out.println("Drawn: "+drawn);
        System.out.println("Skipped: "+skipped);

        for(String s: skip){
            System.out.println(s);
        }
        canvas.show();

    }

}
/*
 * 1- The Shape method is abstract cause shape has no dimention or area of it's own
 * 2- The Rectangle parent class is a concrete class because square is-A type of rectangle
 * 3- setWidth() was overridden cause if only the width is modified and the height is same,then it will become a rectangle
 *    so,both needs to be same
 * 4- area() and draw() method need not to be overridden because it is already in parent class Rectangle working the same thing     */