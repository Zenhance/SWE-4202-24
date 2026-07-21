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

/*
Answer no-
    1. The Shape class is made abstract because it does not require any
    direct instantiation. Shape itself cannot be defined specifically.
    In addition, the canvas only has methods for specific methods like rectangle
    circle rather than just shape.

    2.Rectangle class was made concrete while being a parent class.
    Square class inherited Rectangle class that made it a parent class.
    But rectangle class  itself had properties and methods to implement .
    Thats why Rectangle class was made concrete with its own methods and elements.

    3. The method names setWidth() was Overridden in Square class.
    Though its parent Rectangle had implemented setWidth(), the logic inside contradicted
    with each other. The square shape has only one property "side", while  the rectangle
    shape has width and length. Therefore , the setter for different elements had to be different.
    Hence, SetWidth() was Overriiden in Square class to implement its own property.

    4. I deliberately did not Overriden the area() method in Square class despite changing
    setWidth() than its parent Rectangle. That is because, though the setter logic contradicted
    while setting properties , but the area calculation is same . width * length and side*side.
    therefore i did not over ride it.
 */
