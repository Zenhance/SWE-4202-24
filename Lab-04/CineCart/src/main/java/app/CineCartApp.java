package app;

import engine.CheckoutEngine;
import io . CsvLoader ;
import model .*;
import data .*;


public class CineCartApp {
    public static void main( String[] args ) {
        Movie[] movies = CsvLoader.loadMovies(" movies . csv ");
        Hall[] halls = CsvLoader.loadHalls(" halls . csv ");
        ShowtimeBoard board = CsvLoader.loadShowtimes(" showtimes . csv", movies, halls);
        ConcessionMenu menu = CsvLoader.loadConcessions(" concessions . csv ");
        Customer[] customers = CsvLoader.loadCustomers(" customers . csv ");

        CheckoutEngine checkoutEngine = new CheckoutEngine(board, menu);
        Customer a = customers[0];
        Cart a_cart = new Cart(a);



    }
}