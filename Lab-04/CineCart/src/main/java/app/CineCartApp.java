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
        }
    }
}
