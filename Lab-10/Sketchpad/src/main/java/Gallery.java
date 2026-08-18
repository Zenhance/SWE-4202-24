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

/*
1.Shape is abstract because it stands for any shape at all with no area
formula and nothing to paint of its own a bare shape is nonsense.So
new Shape() must not compile.

2.Rectangle is the parent I left concrete it is itself a real drawable
shape and it doubles as the parent of Square since a square is a rectangle
whose sides are always equal.

3.I overrode setWidth and setHeight in Square even though Rectangle already
implements them because Rectangle's versions would let a square resize
one side without the other and stop being square the parent's behavior
is simply wrong for this child.

4.I deliberately did not override area() or description() in Square
because Rectangle's width x height already equals side^2 when both sides
are equal, so an override would just call super and add nothing.

 */