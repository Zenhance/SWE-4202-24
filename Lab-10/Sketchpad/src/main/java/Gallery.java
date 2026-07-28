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

    public void render()
    {
        int draw=0,skip=0;
        ArrayList<String> skipped = new ArrayList<>();
        for(Shape shape : shapes)
        {
            try
            {
                 shape.draw(canvas);
                 draw++;
            }
            catch(ShapeException e)
            {
                skip++;
                System.out.println(shape.describe());
                System.out.println("Skipped because : "+e.getMessage());
            }
        }
        System.out.println("Drawn : "+draw);
        System.out.println("Skipped : "+skip);
        canvas.show();
    }
}