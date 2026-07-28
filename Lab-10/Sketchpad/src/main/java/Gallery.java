import java.util.ArrayList;

public class Gallery
{
    protected Canvas canvas;
    protected ArrayList<Shape> shapes;

    public Gallery(Canvas canvas)
    {
        this.canvas = canvas;
        shapes = new ArrayList<>();
    }

    public void add(Shape shape)
    {
        shapes.add(shape);
    }

    public int waiting()
    {
        return shapes.size();
    }


}