package app;

import io.CsvLoader;

import model.*;
import data.*;
import engine.*;

public class CineCartApp {

    public static void main(String[] args) {

        // load CSV data
        Movie[] movies =
                CsvLoader.loadMovies("movies.csv");

        Hall[] halls =
                CsvLoader.loadHalls("halls.csv");

        ShowtimeBoard board =
                CsvLoader.loadShowtimes(
                        "showtimes.csv",
                        movies,
                        halls
                );

        ConcessionMenu menu =
                CsvLoader.loadConcessions(
                        "concessions.csv"
                );

        Customer[] customers =
                CsvLoader.loadCustomers(
                        "customers.csv"
                );

        // create engine
        CheckoutEngine engine =
                new CheckoutEngine(board, menu);

        // choose customer
        Customer customer = customers[0];

        // create cart
        Cart cart = new Cart(customer);

        // show showtimes
        System.out.println("=== SHOWTIMES ===");
        board.displayAll();

        // book tickets
        System.out.println(
                engine.bookTicket(cart, 17, 0, 1)
        );

        System.out.println(
                engine.bookTicket(cart, 17, 1, 2)
        );

        // add food items
        System.out.println(
                engine.addConcession(cart, "POP", 1)
        );

        System.out.println(
                engine.addConcession(cart, "SODA", 1)
        );

        // checkout
        double total = engine.checkout(cart);

        // print receipt
        System.out.println("\n=== RECEIPT ===");
        System.out.println(
                engine.getReceipt(cart)
        );

        System.out.println(
                "Final Total: BDT "
                        + String.format("%.2f", total)
        );
    }
}
