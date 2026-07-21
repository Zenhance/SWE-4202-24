import java.util.ArrayList;
import java.util.List;
public class Gallery
{
    private final Canvas canvas;
    private final List<Shape> pile = new ArrayList<>();
    private final List<String> skippedReasons = new ArrayList<>();
    private int nextIndex = 0;
    private int drawnCount = 0;
    public Gallery(Canvas canvas)
    {
        this.canvas = canvas;
    }
    public void add(Shape shape)
    {
        pile.add(shape);
    }
    public int waiting()
    {
        return pile.size() - nextIndex;
    }
    public void render()
    {
        while (nextIndex < pile.size())
        {
            Shape shape = pile.get(nextIndex);
            nextIndex++;
            try
            {
                shape.draw(canvas);
                drawnCount++;
            } catch (ShapeDrawException e) {
                skippedReasons.add(shape.describe() + " -> skipped: " + e.getMessage());
            }
        }
        report();
        canvas.show();
    }
    private void report()
    {
        System.out.println("Drew " + drawnCount + " of " + pile.size() + " shapes.");
        if (skippedReasons.isEmpty())
        {
            System.out.println("Nothing was skipped.");
        }
        else
        {
            System.out.println("Skipped " + skippedReasons.size() + ":");
            for (String reason : skippedReasons)
            {
                System.out.println("  - " + reason);
            }
        }
        System.out.println(waiting() + " shape(s) still waiting to be drawn.");
    }
}