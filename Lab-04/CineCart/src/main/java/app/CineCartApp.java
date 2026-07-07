package app;

import io.CsvLoader;
import Model.*;
import Data.*;
import engine.CheckoutEngine;

public class CineCartApp {
    public static void main(String[] args) {
        Movie[] movies = CsvLoader.loadMovies("movies.csv");
        Hall[] halls = CsvLoader.loadHalls("halls.csv");

        ShowtimeBoard board = CsvLoader.loadShowtimes("showtimes.csv", movies, halls);
        ConcessionMenu menu = CsvLoader.loadConcessions("concessions.csv");
        Customer[] customers = CsvLoader.loadCustomers("customers.csv");

        CheckoutEngine engine = new CheckoutEngine(board, menu);

       Customer customer = customers[0];
        Cart cart = new Cart(customer);

        System.out.println("Available Showtimes:");
        board.displayAll();

        System.out.println();
        System.out.println("Booking Results:");
        System.out.println(engine.bookTicket(cart, 17, 0, 0));
        System.out.println(engine.bookTicket(cart, 17, 0, 1));
        System.out.println(engine.bookTicket(cart, 17, 1, 0));

        System.out.println();
        System.out.println("Adding Concessions:");
        System.out.println(engine.addConcession(cart, "POP", 1));
        System.out.println(engine.addConcession(cart, "SODA", 1));

        System.out.println();
        System.out.println(engine.getReceipt(cart));
    }
}








