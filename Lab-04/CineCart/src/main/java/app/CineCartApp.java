package app;
import data.*;
import model.*;
import data.*;
public class CineCartApp {
    Movie [] movies = CsvLoader . loadMovies (" movies . csv ") ;
    Hall [] halls = CsvLoader . loadHalls (" halls . csv ") ;
    ShowtimeBoard board = CsvLoader . loadShowtimes (
            " showtimes . csv", movies , halls ) ;
    ConcessionMenu menu = CsvLoader . loadConcessions (" concessions . csv ") ;
    Customer [] customers = CsvLoader . loadCustomers (" customers . csv ") ;
}
