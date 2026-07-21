import java.util.ArrayList;
import java.util.List;
public class Gallery
{
    private final Canvas canvas;
    private final List<Shape> pile = new ArrayList<>();
    private final List<String> skippedReasons = new ArrayList<>();
    private int nextIndex = 0;
    private int drawnCount = 0;
}