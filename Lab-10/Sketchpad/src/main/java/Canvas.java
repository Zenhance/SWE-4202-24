/**
 * Canvas — PROVIDED. Do not modify.
 *
 * A tiny console "screen" made of a grid of character cells. It knows how to
 * paint a filled circle and a filled rectangle for you, so your shapes never
 * have to work out which cells to colour in — they just call these primitives.
 *
 * Shapes are stamped left to right; when a shape does not fit on the current
 * row the canvas drops to a new band automatically. Each shape gets its own
 * fill character so a composite picture stay.s readable.
 *
 * The only method your shapes need for their fit-check is {@link #capacity()}.
 */
public class Canvas {

    private final int cols;
    private final int rows;
    private final char[][] grid;

    // where the next shape will be stamped
    private int penCol = 0;
    private int bandTop = 0;
    private int bandHeight = 0;

    private int fillIndex = 0;
    private static final char[] PALETTE = {'#', '*', '@', 'o', '+', '%', '='};

    public Canvas(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.grid = new char[rows][cols];
        clear();
    }

    /** Width of the canvas in cells. */
    public int width() {
        return cols;
    }

    /** Height of the canvas in cells. */
    public int height() {
        return rows;
    }

    /** Total number of cells the canvas can hold — its drawing area. */
    public int capacity() {
        return cols * rows;
    }

    /** Paint a filled circle of the given radius. */
    public void circle(double r) {
        int rad = Math.max(1, (int) Math.round(r));
        int d = 2 * rad + 1;
        final int centre = rad;
        final double limit = (rad + 0.5) * (rad + 0.5);
        stamp(d, d, (x, y) -> {
            double dx = x - centre;
            double dy = y - centre;
            return dx * dx + dy * dy <= limit;
        }, nextFill());
    }

    /** Paint a filled rectangle of the given width and height. */
    public void rectangle(double w, double h) {
        int cw = Math.max(1, (int) Math.round(w));
        int ch = Math.max(1, (int) Math.round(h));
        stamp(cw, ch, (x, y) -> true, nextFill());
    }

    /** Print the current picture to the console, inside a border. */
    public void show() {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (int c = 0; c < cols; c++) sb.append('-');
        sb.append("+\n");
        for (int r = 0; r < rows; r++) {
            sb.append('|');
            sb.append(grid[r]);
            sb.append("|\n");
        }
        sb.append('+');
        for (int c = 0; c < cols; c++) sb.append('-');
        sb.append('+');
        System.out.println(sb);
    }

    /** Wipe the canvas back to blank and move the pen home. */
    public void clear() {
        for (char[] row : grid) java.util.Arrays.fill(row, ' ');
        penCol = 0;
        bandTop = 0;
        bandHeight = 0;
        fillIndex = 0;
    }

    // --- internal placement -------------------------------------------------

    private void stamp(int w, int h, Mask mask, char fill) {
        if (penCol + w > cols) {          // no room on this band: start a new one
            penCol = 0;
            bandTop += bandHeight + 1;
            bandHeight = 0;
        }
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int gc = penCol + x;
                int gr = bandTop + y;
                if (gc >= 0 && gc < cols && gr >= 0 && gr < rows && mask.on(x, y)) {
                    grid[gr][gc] = fill;
                }
            }
        }
        penCol += w + 1;
        if (h > bandHeight) bandHeight = h;
    }

    private char nextFill() {
        char c = PALETTE[fillIndex % PALETTE.length];
        fillIndex++;
        return c;
    }

    /** Which cells of a stamp are filled. */
    private interface Mask {
        boolean on(int x, int y);
    }
}
