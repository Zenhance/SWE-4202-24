package shop;

import java.util.List;
import dokan.Box;
import dokan.Check;
import dokan.Counter;
import dokan.Item;
import dokan.Pair;
import dokan.Shelf;
import dokan.Shelves;

/**
 * A day at Rahim's shop: {@code ./gradlew run}
 *
 * <p>Read the code as much as the output. Every shelf below is the same {@code Shelf}
 * class, and there is not one cast in this file.
 */
public final class Main {

    public static void main(String[] args) {
        header("1. Three shelves, one Shelf class");
        Shelf<Book> books = new Shelf<>(4);
        Shelf<Snack> snacks = new Shelf<>(4);
        Shelf<SimCard> sims = new Shelf<>(4);
        Shelves.addAll(books, Sample.BOOKS);
        Shelves.addAll(snacks, Sample.SNACKS);
        Shelves.addAll(sims, Sample.SIMS);
        System.out.println("  books : " + books + "  worth " + books.totalPriceTaka() + " Tk");
        System.out.println("  snacks: " + snacks + "  worth " + snacks.totalPriceTaka() + " Tk");
        System.out.println("  sims  : " + sims + "  worth " + sims.totalPriceTaka() + " Tk");

        header("2. The cheapest thing on each shelf");
        System.out.println("  books : " + Shelves.cheapest(books));
        System.out.println("  snacks: " + Shelves.cheapest(snacks));
        System.out.println("  empty : " + Shelves.cheapest(new Shelf<Book>(4))
                + "   <- no crash, no null");

        header("3. A shelf goes full, and says so");
        Shelf<Book> small = new Shelf<>(2);
        int added = Shelves.addAll(small, Sample.BOOKS);
        System.out.println("  tried to shelve 3 books on a shelf of 2: " + added + " went on");
        System.out.println("  one more? " + small.add(Sample.HIMU));

        header("4. Only the cheap books, please");
        Check<Item> under300 = item -> item.priceTaka() < 300;
        for (Book book : Shelves.keep(books, under300)) {
            System.out.println("  " + book);
        }

        header("5. One max() for numbers and for names");
        System.out.println("  dearest snack costs " + Shelves.max(List.of(40, 25, 30)) + " Tk");
        System.out.println("  last name alphabetically: "
                + Shelves.max(List.of("Chanachur", "Biscuit", "Chips")));

        header("6. What sold today");
        Counter<String> sales = new Counter<>();
        for (String sold : List.of("Chanachur", "Biscuit", "Chanachur", "Chips", "Chanachur")) {
            sales.add(sold);
        }
        System.out.println("  " + sales.distinct() + " different things sold");
        System.out.println("  Chanachur sold " + sales.count("Chanachur") + " times");
        Box<String> best = sales.mostCommon();
        System.out.println("  best seller: " + best.orElse("nothing sold yet"));

        header("7. Two things kept together");
        Pair<String, Integer> bestSeller = new Pair<>(best.orElse("-"), sales.count("Chanachur"));
        System.out.println("  " + bestSeller + "  and the other way round: " + bestSeller.swapped());

        header("8. The point of the whole exercise");
        System.out.println("  One Shelf class. One Box class. One Counter class. Zero casts.");
        System.out.println("  books.add(Sample.CHANACHUR) would not even compile - try it.");
    }

    private static void header(String title) {
        System.out.println();
        System.out.println(title);
        System.out.println("-".repeat(title.length()));
    }

    private Main() {
    }
}
