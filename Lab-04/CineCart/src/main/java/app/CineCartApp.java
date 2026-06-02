package app;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import io.CsvLoader;
import model.*;
import engine.CheckoutEngine;


public class CineCartApp {


    Movie[] movies = CsvLoader . loadMovies (" movies . csv ") ;
    Hall[] halls = CsvLoader. loadHalls (" halls . csv ") ;
    ShowtimeBoard board = CsvLoader . loadShowtimes (" showtimes . csv", movies , halls ) ;
    ConcessionMenu menu = CsvLoader . loadConcessions (" concessions . csv ") ;
    Customer[] customers = CsvLoader . loadCustomers (" customers . csv ") ;
    Cart carta= new Cart(customers[1]);
    CheckoutEngine engine = new CheckoutEngine(board,menu);
    //board.displayAll();

}
