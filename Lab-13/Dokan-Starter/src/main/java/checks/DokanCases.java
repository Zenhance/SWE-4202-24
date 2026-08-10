package checks;

import java.util.ArrayList;
import java.util.List;
import dokan.Box;
import dokan.Check;
import dokan.Counter;
import dokan.Item;
import dokan.Pair;
import dokan.Shelf;
import dokan.Shelves;
import shop.Book;
import shop.Sample;
import shop.SimCard;
import shop.Snack;

/**
 * Run this as often as you like: {@code ./gradlew cases}
 *
 * <p>Every case prints its Input, the Expected output, what your code Actually
 * produced, and an Explanation of why the expected answer is what it is. Nothing here
 * is graded; it exists so you can see exactly which piece you have not built yet.
 *
 * <p>Work down the list. A case that says {@code not implemented yet} is a method
 * still throwing {@code UnsupportedOperationException}.
 */
public final class DokanCases {

    private static int caseNumber;
    private static int passed;

    public static void main(String[] args) {
        banner("DOKAN - TEST CASES");

        group("Box<T> - a value, or nothing at all");
        expect("An empty box knows it is empty",
                "Box.empty().isEmpty()",
                "true",
                () -> Box.empty().isEmpty(),
                "No null anywhere. 'Nothing here' is a value you can ask questions of.");

        expect("A full box gives its value back",
                "Box.of(\"Chanachur\").get()",
                "Chanachur",
                () -> Box.of("Chanachur").get(),
                "Box.of(\"...\") makes a Box<String>, so get() returns a String. "
                        + "No cast, because the box remembers what it holds.");

        expect("Opening an empty box is a programming mistake",
                "Box.empty().get()",
                "IllegalStateException",
                () -> Box.empty().get(),
                "Returning a value would be a lie; returning null would put us back "
                        + "where the intern was. So it throws.");

        expect("orElse gives a fallback instead",
                "Box.<Book>empty().orElse(GRAMMAR).name()",
                "Bangla Grammar",
                () -> Box.<Book>empty().orElse(Sample.GRAMMAR).name(),
                "The fallback must be a Book, because the box is a Box<Book>. "
                        + "Try passing a Snack and see what javac says.");

        group("Pair<A, B> - two type parameters at once");
        expect("A pair holds two different types together",
                "new Pair<>(\"Chanachur\", 40)",
                "(Chanachur, 40)",
                () -> new Pair<>("Chanachur", 40),
                "A is String and B is Integer. They are independent: nothing forces "
                        + "them to be the same type.");

        expect("swapped() swaps the types too",
                "new Pair<>(\"Chanachur\", 40).swapped()",
                "(40, Chanachur)",
                () -> new Pair<>("Chanachur", 40).swapped(),
                "A Pair<String,Integer> became a Pair<Integer,String>. The compiler "
                        + "tracked that on its own - look at the return type of swapped().");

        expect("...and the compiler really does know the new order",
                "pair.swapped().first() + 1",
                "41",
                () -> new Pair<>("Chanachur", 40).swapped().first() + 1,
                "first() is an Integer after the swap, so arithmetic on it compiles. "
                        + "Before the swap it was a String and this line would not.");

        group("Shelf<T extends Item> - one shelf class for every kind of good");
        expect("Three books on a shelf",
                "shelf of capacity 4; add Nondito, Feluda, Grammar",
                "size=3",
                () -> "size=" + bookShelf().size(),
                "");

        expect("What the shelf is worth",
                "totalPriceTaka() of those three books",
                "1130",
                () -> bookShelf().totalPriceTaka(),
                "250 + 700 + 180. This method can only call priceTaka() because of the "
                        + "bound <T extends Item>. Remove the bound and it stops compiling.");

        expect("A full shelf refuses more",
                "capacity 4; add a 4th book, then a 5th",
                "4th=true full=true 5th=false size=4",
                () -> {
                    Shelf<Book> shelf = bookShelf();
                    boolean fourth = shelf.add(Sample.HIMU);
                    boolean fifth = shelf.add(Sample.NONDITO);
                    return "4th=" + fourth + " full=" + shelf.isFull()
                            + " 5th=" + fifth + " size=" + shelf.size();
                },
                "Refusing is an ordinary answer, so it is a false, not an exception.");

        expect("contains() looks by name",
                "contains(\"Feluda Samagra\") and contains(\"Chips\")",
                "true false",
                () -> bookShelf().contains("Feluda Samagra") + " " + bookShelf().contains("Chips"),
                "");

        expect("remove() leaves no hole behind",
                "remove(\"Feluda Samagra\") from the three books",
                "removed=true size=2 total=430",
                () -> {
                    Shelf<Book> shelf = bookShelf();
                    boolean removed = shelf.remove("Feluda Samagra");
                    return "removed=" + removed + " size=" + shelf.size()
                            + " total=" + shelf.totalPriceTaka();
                },
                "250 + 180 = 430. This is the intern's PAIN 2: his SnackShelf blanks "
                        + "the slot but keeps the count, and then blows up.");

        expect("The very same class, holding snacks",
                "Shelf<Snack>; add Chanachur, Biscuit, Chips",
                "size=3 total=95",
                () -> {
                    Shelf<Snack> shelf = new Shelf<>(4);
                    for (Snack snack : Sample.SNACKS) {
                        shelf.add(snack);
                    }
                    return "size=" + shelf.size() + " total=" + shelf.totalPriceTaka();
                },
                "40 + 25 + 30. Not one line of Shelf was copied or changed to make this "
                        + "work. The intern needed a whole second file.");

        group("Counter<T> - counting anything at all");
        expect("Counting what sold today",
                "add Chanachur x3, Biscuit, Chips; count(\"Chanachur\")",
                "3",
                () -> salesCounter().count("Chanachur"),
                "T is unbounded here: a Counter can count anything that can sit in a "
                        + "HashMap. It does not need to know about items at all.");

        expect("Something never seen has a count of zero",
                "count(\"Chocolate\")",
                "0",
                () -> salesCounter().count("Chocolate"),
                "Not null, not an exception. Zero.");

        expect("How many different things sold",
                "distinct()",
                "3",
                () -> salesCounter().distinct(),
                "");

        expect("The best seller comes back in a Box",
                "mostCommon()",
                "Box(Chanachur)",
                () -> salesCounter().mostCommon(),
                "Counter<String>.mostCommon() returns a Box<String>. The type parameter "
                        + "travels from one generic class into another.");

        expect("Nothing sold yet, so the box is empty",
                "new Counter<String>().mostCommon()",
                "Box(empty)",
                () -> new Counter<String>().mostCommon(),
                "No special case, no null, no crash - the empty box already means this.");

        expect("The same Counter class, counting Books",
                "Counter<Book>; add NONDITO twice, FELUDA once",
                "count(NONDITO)=2 best=Nondito Noroke (250 Tk)",
                () -> {
                    Counter<Book> counter = new Counter<>();
                    counter.add(Sample.NONDITO);
                    counter.add(Sample.FELUDA);
                    counter.add(Sample.NONDITO);
                    return "count(NONDITO)=" + counter.count(Sample.NONDITO)
                            + " best=" + counter.mostCommon().get();
                },
                "Strings on one line, Books on the next, one class for both.");

        group("Shelves - static generic methods");
        expect("The cheapest book on the shelf",
                "Shelves.cheapest(bookShelf)",
                "Bangla Grammar",
                () -> Shelves.cheapest(bookShelf()).get().name(),
                "You wrote Shelves.cheapest(shelf), not Shelves.<Book>cheapest(shelf). "
                        + "The compiler worked out T = Book by itself. That is inference.");

        expect("The cheapest thing on an empty shelf",
                "Shelves.cheapest(new Shelf<Book>(4))",
                "Box(empty)",
                () -> Shelves.cheapest(new Shelf<Book>(4)),
                "The intern returned null here and the next line threw. This cannot.");

        expect("Keeping only the books under 300 Taka",
                "Shelves.keep(bookShelf, item -> item.priceTaka() < 300)",
                "[Nondito Noroke, Bangla Grammar]",
                () -> {
                    Check<Item> cheap = item -> item.priceTaka() < 300;
                    return names(Shelves.keep(bookShelf(), cheap));
                },
                "Note the check is a Check<Item> but the shelf is a Shelf<Book>. That "
                        + "only compiles because keep takes Check<? super T> - consumer super. "
                        + "A test that works for any item obviously works for a book.");

        expect("max() on numbers",
                "Shelves.max(List.of(40, 25, 30))",
                "40",
                () -> Shelves.max(List.of(40, 25, 30)),
                "The bound <T extends Comparable<T>> is what allows compareTo here.");

        expect("...and the same max() on text",
                "Shelves.max(List.of(\"Chanachur\", \"Biscuit\", \"Chips\"))",
                "Chips",
                () -> Shelves.max(List.of("Chanachur", "Biscuit", "Chips")),
                "Alphabetically last. One method, two completely different types, "
                        + "no overloading and no copy-paste.");

        expect("Pouring a List<Book> onto a Shelf<Item>",
                "Shelves.addAll(new Shelf<Item>(4), BOOKS)",
                "added=3 total=1130",
                () -> {
                    Shelf<Item> mixed = new Shelf<>(4);
                    int added = Shelves.addAll(mixed, Sample.BOOKS);
                    return "added=" + added + " total=" + mixed.totalPriceTaka();
                },
                "The list only hands books over, so addAll takes List<? extends T> - "
                        + "producer extends. With plain List<T> this line would not compile, "
                        + "because a List<Book> is not a List<Item>.");

        expect("addAll stops when the shelf fills up",
                "Shelf<Book> of capacity 2; addAll 3 books",
                "added=2 size=2",
                () -> {
                    Shelf<Book> small = new Shelf<>(2);
                    int added = Shelves.addAll(small, Sample.BOOKS);
                    return "added=" + added + " size=" + small.size();
                },
                "");

        group("The payoff");
        expect("One Shelf class, three kinds of goods",
                "Shelf<Book>, Shelf<Snack>, Shelf<SimCard>",
                "books=3 snacks=3 sims=2",
                () -> {
                    Shelf<Book> books = new Shelf<>(4);
                    Shelves.addAll(books, Sample.BOOKS);
                    Shelf<Snack> snacks = new Shelf<>(4);
                    Shelves.addAll(snacks, Sample.SNACKS);
                    Shelf<SimCard> sims = new Shelf<>(4);
                    Shelves.addAll(sims, Sample.SIMS);
                    return "books=" + books.size() + " snacks=" + snacks.size()
                            + " sims=" + sims.size();
                },
                "One class, written once. The intern wrote BookShelf and SnackShelf and "
                        + "would have needed SimCardShelf next - and he fixed his bug in "
                        + "only one of them.");

        summary();
    }

    // ---- shared fixtures --------------------------------------------------

    /** The three books on a shelf of capacity 4. */
    private static Shelf<Book> bookShelf() {
        Shelf<Book> shelf = new Shelf<>(4);
        for (Book book : Sample.BOOKS) {
            shelf.add(book);
        }
        return shelf;
    }

    /** Chanachur sold three times, Biscuit and Chips once each. */
    private static Counter<String> salesCounter() {
        Counter<String> counter = new Counter<>();
        counter.add("Chanachur");
        counter.add("Biscuit");
        counter.add("Chanachur");
        counter.add("Chips");
        counter.add("Chanachur");
        return counter;
    }

    // ---- the tiny harness -------------------------------------------------

    /** A case body that is allowed to blow up; the harness reports what came out. */
    private interface Body {
        Object run() throws Exception;
    }

    private static void expect(String title, String input, String expected, Body body,
                               String explanation) {
        caseNumber++;
        String actual = describe(body);
        boolean ok = expected.equals(actual);
        if (ok) {
            passed++;
        }
        System.out.println();
        System.out.println("Case " + caseNumber + " - " + title);
        System.out.println("  Input       : " + input);
        System.out.println("  Expected    : " + expected);
        System.out.println("  Actual      : " + actual);
        System.out.println("  Status      : " + (ok ? "PASS" : "FAIL"));
        if (!explanation.isEmpty()) {
            System.out.println("  Explanation : " + wrap(explanation));
        }
    }

    private static String describe(Body body) {
        try {
            return String.valueOf(body.run());
        } catch (UnsupportedOperationException e) {
            return "not implemented yet (TODO)";
        } catch (Throwable t) {
            return t.getClass().getSimpleName();
        }
    }

    /** Names of a list of items, so the expected values stay readable. */
    private static String names(List<? extends Item> items) {
        List<String> out = new ArrayList<>();
        for (Item item : items) {
            out.add(item.name());
        }
        return out.toString();
    }

    private static void banner(String title) {
        System.out.println("=".repeat(78));
        System.out.println(" " + title);
        System.out.println("=".repeat(78));
    }

    private static void group(String title) {
        System.out.println();
        System.out.println("-".repeat(78));
        System.out.println(" " + title);
        System.out.println("-".repeat(78));
    }

    private static void summary() {
        System.out.println();
        System.out.println("=".repeat(78));
        System.out.println(" " + passed + " of " + caseNumber + " cases passed");
        if (passed < caseNumber) {
            System.out.println(" Keep going - fix the first FAIL from the top and run it again.");
        } else {
            System.out.println(" All cases pass. Now run './gradlew test' for the graded suite.");
        }
        System.out.println("=".repeat(78));
    }

    /** Keeps long explanations inside a terminal window. */
    private static String wrap(String text) {
        StringBuilder out = new StringBuilder();
        int lineLength = 0;
        for (String word : text.split(" ")) {
            if (lineLength + word.length() > 60) {
                out.append(System.lineSeparator()).append("                ");
                lineLength = 0;
            }
            out.append(word).append(' ');
            lineLength += word.length() + 1;
        }
        return out.toString().stripTrailing();
    }

    private DokanCases() {
    }
}
