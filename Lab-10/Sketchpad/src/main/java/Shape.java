package main.java;

import java.awt.*;

public abstract class Shape {
    public abstract String describe();

    public abstract double area();

    public abstract void draw(Canvas canvas) throws ShapeException;

}
