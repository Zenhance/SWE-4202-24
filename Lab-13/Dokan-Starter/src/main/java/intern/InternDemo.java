package intern;

import shop.Sample;

/**
 * Run this first: {@code ./gradlew intern}
 *
 * <p>Three things are wrong with the intern's shop, and this makes all three happen in
 * front of you. Each one is a mistake the compiler could have caught, if only somebody
 * had told it what was on the shelf.
 */
public final class InternDemo {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println(" THE INTERN'S DOKAN - three pains, live");
        System.out.println("=".repeat(70));
        painOne();
        painTwo();
        painThree();
        System.out.println();
        System.out.println("All three are fixable with type parameters. That is this lab.");
    }

    /** Pain 1: Object in, Object out, so the wrong thing is only caught at the till. */
    private static void painOne() {
        System.out.println();
        System.out.println("PAIN 1 - the shelf holds Object, so it holds anything");

        ObjectShelf shelf = new ObjectShelf(4);
        shelf.add(Sample.NONDITO);
        shelf.add(Sample.CHANACHUR);        // a snack, on the book shelf. javac is fine with it.

        System.out.println("  added a Book and a Snack to the same shelf: size = " + shelf.size());
        System.out.println("  now asking that shelf for its cheapest book:");
        try {
            System.out.println("  cheapest = " + shelf.cheapest());
        } catch (ClassCastException e) {
            System.out.println("  ClassCastException at runtime -> " + e.getMessage());
        }
        System.out.println("  Nothing was wrong with the CODE. Something was wrong with the TYPES,");
        System.out.println("  and nobody had written the types down.");
    }

    /** Pain 2: two copies of one shelf, so a fix lands in one of them. */
    private static void painTwo() {
        System.out.println();
        System.out.println("PAIN 2 - one bug, fixed once, still live in the copy");

        BookShelf books = new BookShelf(4);
        books.add(Sample.NONDITO);
        books.add(Sample.FELUDA);
        books.add(Sample.GRAMMAR);
        books.remove("Feluda Samagra");
        System.out.println("  BookShelf  after removing the middle book: size = " + books.size()
                + ", total = " + books.totalPriceTaka() + " Tk   (correct)");

        SnackShelf snacks = new SnackShelf(4);
        snacks.add(Sample.CHANACHUR);
        snacks.add(Sample.BISCUIT);
        snacks.add(Sample.CHIPS);
        snacks.remove("Biscuit");
        System.out.print("  SnackShelf after removing the middle snack: size = " + snacks.size());
        try {
            System.out.println(", total = " + snacks.totalPriceTaka() + " Tk");
        } catch (NullPointerException e) {
            System.out.println(", total = NullPointerException   (the same bug, unfixed)");
        }
        System.out.println("  Copies do not inherit fixes. Instances of one generic class do.");
    }

    /** Pain 3: null cannot say "the shelf was empty". */
    private static void painThree() {
        System.out.println();
        System.out.println("PAIN 3 - null is not an answer");

        ObjectShelf empty = new ObjectShelf(4);
        Object cheapest = empty.cheapest();
        System.out.println("  cheapest() on an empty shelf returned " + cheapest);
        System.out.println("  so the very next line does this:");
        try {
            System.out.println("  its price is " + ((shop.Book) cheapest).priceTaka());
        } catch (NullPointerException e) {
            System.out.println("  NullPointerException");
        }
        System.out.println("  'The shelf is empty' is a perfectly ordinary answer.");
        System.out.println("  It deserves a value that can say so. That is what Box<T> is for.");
    }

    private InternDemo() {
    }
}
