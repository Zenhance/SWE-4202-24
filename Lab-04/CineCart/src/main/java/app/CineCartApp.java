package app;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import io.CsvLoader;
import model.Cart;
import model.Customer;
import model.Hall;
import model.Movie;
import engine.CheckoutEngine;


public class CineCartApp {


    Movie[] movies = CsvLoader . loadMovies (" movies . csv ") ;
    Hall[] halls = CsvLoader. loadHalls (" halls . csv ") ;
    ShowtimeBoard board = CsvLoader . loadShowtimes (" showtimes . csv", movies , halls ) ;
    ConcessionMenu menu = CsvLoader . loadConcessions (" concessions . csv ") ;
    Customer[] customers = CsvLoader . loadCustomers (" customers . csv ") ;
    Cart carta= new Cart(customers[1]);





}
