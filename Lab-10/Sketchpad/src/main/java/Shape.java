package main.java;

import java.awt.*;

public abstract class Shape {

    public Shape() {
    }
    public abstract double area();
    public abstract void draw(Canvas canvas) throws ShapeTooLargeException, ShapeTooSmallException;
    public abstract String toString();
}