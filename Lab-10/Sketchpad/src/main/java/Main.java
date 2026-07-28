/**
 * Main — PROVIDED. Do not modify.
 *
 * Runs the whole kit. Reading this file tells you how your classes will be
 * used: the constructors, the gallery methods, and the resize behaviour a
 * square must honour. When every TODO is done, running Main should:
 *   - draw the three shapes that fit and skip the two that do not,
 *   - print a report saying which were skipped and why,
 *   - show the finished picture,
 *   - prove a square stays square when you resize it,
 *   - and prove a malformed shape is rejected the moment it is constructed.
 */
public class Main {

    public static void main(String[] args) {
        Canvas canvas = new Canvas(40, 20);   // capacity = 40 * 20 = 800 cells
        Gallery gallery = new Gallery(canvas);

        // A mixed pile: three fit, two the canvas must refuse.
        gallery.add(new Circle(4));          // area ~50   -> fits
        gallery.add(new Rectangle(1000, 5));   // area 50    -> fits
        gallery.add(new Square(6));          // area 36    -> fits
        gallery.add(new Circle(16));         // area ~1256 -> too large for 800
        gallery.add(new Square(0.5));        // area 0.25  -> too small for one cell

        System.out.println(gallery.waiting() + " shapes waiting to be drawn:\n");
        gallery.render();

        // A square keeps all sides equal: changing one side changes both.
        System.out.println("\nResize demo:");
        Square sq = new Square(4);
        System.out.println("  before:            " + sq.describe());
        sq.setWidth(9);                      // Square must override so the height follows
        System.out.println("  after setWidth(9): " + sq.describe() + "   (should still be a square)");

        // A malformed shape must be rejected at construction (unchecked).
        System.out.println("\nConstruction guard:");
        try {
            new Circle(-3);
            System.out.println("  BUG: a circle of radius -3 was allowed to exist");
        } catch (IllegalArgumentException e) {
            System.out.println("  rejected as expected: " + e.getMessage());
        }
    }
}
