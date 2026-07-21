package main.java;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private Canvas canvas;
    private List<Shape> shapes=new ArrayList<>();

    public Gallery(Canvas canvas){
        this.canvas=canvas;
    }
    public void add(Shape shape){
        shapes.add(shape);
    }
    public void render(){
        int drawn =0;
        int skipped=0;
        ArrayList<String>report=new ArrayList<>();
        for(Shape shape:shapes){
            try{
                shape.draw(canvas);
                drawn++;
            }
            catch(ShapeException e){
                skipped++;
            }

        }
    }

}
