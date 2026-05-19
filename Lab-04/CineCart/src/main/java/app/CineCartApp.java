package app;
import model.Movie;
import io.CsvLoader;
import data.ShowtimeBoard;
import model.Hall;
import data.ConcessionMenu;
import model.Customer;
import engine.CheckoutEngine;
import model.Cart;


public class CineCartApp {

    public static void main(String[] args) {


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


        CheckoutEngine engine =
                new CheckoutEngine(board, menu);



        System.out.println("=== SHOWTIMES ===");
        board.displayAll();

        System.out.println(
                engine.bookTicket(cart, 17, 0, 1)
        );

        System.out.println(
                engine.bookTicket(cart, 17, 1, 2)
        );
        System.out.println(
                engine.addConcession(cart, "POP", 1)
        );

        System.out.println(
                engine.addConcession(cart, "SODA", 1)
        );
        double total = engine.checkout(cart);

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
