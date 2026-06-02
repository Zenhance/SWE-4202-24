package app;
import engine.CheckoutEngine;
import io.CsvLoader;
import model.*;
import data.*;
import service.*;

public class CineCartApp {
    public static void main(String[] args){
        Movie[] movies = CsvLoader.loadMovies("movies.csv");
        Hall[] halls= CsvLoader.loadHalls("halls.csv");
        ShowtimeBoard board =CsvLoader.loadShowtimes{
            "showtimes.csv",movies,halls);
ConcessionMenu menu =CsvLoader.loadConcessions("concessions.csv");
Customer[]customers = CsvLoader.loadConcessions("concessions.csv");
            CheckoutEngine engine = new CheckoutEngine(board,menu);
            Customer customer = customers[0];
            Cart cart = new Cart(customer);

            System.out.println("SHOWTIMES");
            board.displayAll();

            System.out.println(engine.bookTicket(cart,17,0,0));
            System.out.println(engine.bookTicket(cart,17,1,1));
            System.out.println(engine.bookTicket(cart,999,1,1));
            System.out.println();
            System.out.println(engine.addConcession(cart,"POP",1));






        }
    }
}
