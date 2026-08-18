package app;

import io.CsvLoader;
import model.*;
import data.*;
import engine.CheckoutEngine;

// CineCartApp is the entry point of the whole system.
// It loads all the data from CSV files, sets up the engine,
// and runs through a sample booking session to show everything works together.
public class CineCartApp {

    public static void main(String[] args) {

        // ---------------------------------------------------------------
        // STEP 1: Load all data from the CSV files.
        // The CsvLoader reads each file and builds the Java objects for us.
        // ---------------------------------------------------------------
        Movie[]        movies    = CsvLoader.loadMovies("movies.csv");
        Hall[]         halls     = CsvLoader.loadHalls("halls.csv");
        ShowtimeBoard  board     = CsvLoader.loadShowtimes("showtimes.csv", movies, halls);
        ConcessionMenu menu      = CsvLoader.loadConcessions("concessions.csv");
        Customer[]     customers = CsvLoader.loadCustomers("customers.csv");

        System.out.println("Data loaded successfully.");
        System.out.println("Movies: " + movies.length);
        System.out.println("Halls: " + halls.length);
        System.out.println("Customers: " + customers.length);
        System.out.println();

        // ---------------------------------------------------------------
        // STEP 2: Set up the checkout engine with the loaded data
        // ---------------------------------------------------------------
        CheckoutEngine engine = new CheckoutEngine(board, menu);

        // ---------------------------------------------------------------
        // STEP 3: Pick a customer and open a cart for them.
        // Customer 0 = Alice (GOLD tier, age 28) — a good test case.
        // ---------------------------------------------------------------
        Customer alice = customers[0];  // Alice, GOLD, age 28
        Cart cart = new Cart(alice);
        System.out.println("Opened cart for: " + alice);
        System.out.println();

        // ---------------------------------------------------------------
        // STEP 4: Display what's available
        // ---------------------------------------------------------------
        board.displayAll();
        System.out.println();
        menu.displayAll();
        System.out.println();

        // Show the seat layout for Hall 2 (used by showtime T17)
        halls[1].displayLayout();  // halls[1] is Hall with id=2
        System.out.println();

        // ---------------------------------------------------------------
        // STEP 5: Book a few tickets
        // ---------------------------------------------------------------

        // Book a seat at showtime 17 (Inception, Hall 2, 19:00 Fri - PEAK)
        // Row 0 is premium, row 1+ is normal
        String result1 = engine.bookTicket(cart, 17, 0, 0);  // premium seat, peak time
        System.out.println("Booking T17 R0C0 -> " + result1);

        String result2 = engine.bookTicket(cart, 17, 2, 3);  // normal seat
        System.out.println("Booking T17 R2C3 -> " + result2);

        // Try to book the same seat again — should be rejected
        String result3 = engine.bookTicket(cart, 17, 0, 0);
        System.out.println("Booking T17 R0C0 again -> " + result3);

        // Try a showtime that doesn't exist
        String result4 = engine.bookTicket(cart, 999, 0, 0);
        System.out.println("Booking T999 -> " + result4);

        System.out.println();

        // ---------------------------------------------------------------
        // STEP 6: Add some snacks (popcorn + soda triggers the combo deal!)
        // ---------------------------------------------------------------
        String snack1 = engine.addConcession(cart, "POP", 1);
        System.out.println("Add POP -> " + snack1);

        String snack2 = engine.addConcession(cart, "SODA", 1);
        System.out.println("Add SODA -> " + snack2);

        String snack3 = engine.addConcession(cart, "NACHO", 1);
        System.out.println("Add NACHO -> " + snack3);

        // Try adding something that doesn't exist on the menu
        String snack4 = engine.addConcession(cart, "PIZZA", 1);
        System.out.println("Add PIZZA -> " + snack4);

        System.out.println();

        // ---------------------------------------------------------------
        // STEP 7: Checkout and print the receipt
        // ---------------------------------------------------------------
        double finalAmount = engine.checkout(cart);
        System.out.println("Final amount to pay: BDT " + String.format("%.2f", finalAmount));
        System.out.println();

        String receipt = engine.getReceipt(cart);
        System.out.println(receipt);
    }
}
