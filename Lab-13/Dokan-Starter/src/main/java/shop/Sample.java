package shop;

import java.util.List;

/**
 * The goods every example, test case and unit test uses. Kept in one place so the
 * numbers in the lab sheet, the case runner and the JUnit suite cannot drift apart.
 */
public final class Sample {

    //                                         name              price  extra
    public static final Book NONDITO = new Book("Nondito Noroke",  250, "Humayun Ahmed");
    public static final Book FELUDA  = new Book("Feluda Samagra",  700, "Satyajit Ray");
    public static final Book GRAMMAR = new Book("Bangla Grammar",  180, "Text Board");
    public static final Book HIMU    = new Book("Himu",            320, "Humayun Ahmed");

    public static final Snack CHANACHUR = new Snack("Chanachur", 40, 100);
    public static final Snack BISCUIT   = new Snack("Biscuit",   25,  80);
    public static final Snack CHIPS     = new Snack("Chips",     30,  50);

    public static final SimCard GP   = new SimCard("GP SIM",   200, "Grameenphone");
    public static final SimCard ROBI = new SimCard("Robi SIM", 150, "Robi");

    /** The three books Rahim starts the day with: 250 + 700 + 180 = 1130 Taka. */
    public static final List<Book> BOOKS = List.of(NONDITO, FELUDA, GRAMMAR);

    public static final List<Snack> SNACKS = List.of(CHANACHUR, BISCUIT, CHIPS);

    public static final List<SimCard> SIMS = List.of(GP, ROBI);

    private Sample() {
    }
}
