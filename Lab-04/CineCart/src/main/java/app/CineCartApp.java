package app;
import io.CsvLoader;
import model.*;
import data.*;
import engine.*;

public class CineCartApp {
    public static void main(String[] args) {
        Movie[] movies = CsvLoader.loadMovies("movies.csv");
        Hall[] halls = CsvLoader.loadHalls("halls.csv");
        ShowtimeBoard board = CsvLoader.loadShowtimes("showtimes.csv", movies, halls);
        ConcessionMenu menu = CsvLoader.loadConcessions("concessions.csv");
        Customer[] customers = CsvLoader.loadCustomers("customers.csv");

        CheckoutEngine engine = new CheckoutEngine(board, menu);

        Customer alice = customers[0];
        Cart cart = new Cart(alice);

        board.displayAll();

        System.out.println(engine.bookTicket(cart, 17, 0, 0));
        System.out.println(engine.bookTicket(cart, 17, 0, 1));
        System.out.println(engine.bookTicket(cart, 17, 0, 2));
        System.out.println(engine.bookTicket(cart, 17, 0, 3));

        System.out.println(engine.addConcession(cart, "POP", 1));
        System.out.println(engine.addConcession(cart, "SODA", 1));

        System.out.println(engine.getReceipt(cart));
    }
}
