package main.java;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private final Canvas canvas;
    private final List<Shape> shapes = new ArrayList<>();

    public Gallery(Canvas canvas) {
        this.canvas = canvas;
    }

    public void add(Rectangle shape) {
        shapes.add(shape);
    }
    public int waiting() {
        return shapes.size();
    }
    public void render() {
        int drawn = 0;
        int skipped = 0;
        List<String> skipReasons = new ArrayList<>();
        for (Shape shape : shapes) {
            try {
                shape.draw(canvas);
                drawn++;
            } catch (ShapeException e) {
                skipped++;
                skipReasons.add(shape.describe() + " -> skipped: " + e.getMessage());
            }
        }
        System.out.println("drawn: " + drawn + " skipped: " + skipped + " reasons: " + skipReasons);
        canvas.show();
    }
}