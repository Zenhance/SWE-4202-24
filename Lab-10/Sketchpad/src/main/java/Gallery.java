import java.util.ArrayList;

public class Gallery {

    private Canvas canvas;
    private ArrayList<Shape> shapes;

    public Gallery(Canvas canvas){
        this.canvas=canvas;
        shapes=new ArrayList<>();
    }

    public void add(Shape s) {
        shapes.add(s);
    }

    public int waiting() {
        return shapes.size();
    }

    public void render(){
    for (Shape s : shapes) {
    try {
        s.draw(canvas);
    }
    catch (ShapeException e){
        System.out.println(e.getMessage());
    }

    } canvas.show();
}  }

// Q1.in my case Shape and Shape exception are abstract, because
// shape without any definition of how it looks should not be
//      constructed and ShapeException is a general exception which
//      should not be called, instead specific exceptions should be called.

//Q2.I left Rectangle CLass concrete because a rectangle shape is a valid shape which should
//be allowed to be created.

//Q3.the setWidth method was overridden by square's setWidth
// though being implemented at Rectangle,because both set and width should be changed and
//be equal to each other











