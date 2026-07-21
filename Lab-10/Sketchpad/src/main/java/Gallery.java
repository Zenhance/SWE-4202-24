package main.java;

import java.awt.*;
import java.util.ArrayList;

public class Gallery {
    private Canvas canvas;
    private ArrayList<Shape> shapes;

    public Gallery(Canvas canvas){
        this.canvas = canvas;
        shapes = new ArrayList<>();
    }
}
