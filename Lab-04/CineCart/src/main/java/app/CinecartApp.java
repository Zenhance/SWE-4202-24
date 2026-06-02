package app;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import io.CsvLoader;
import model.Customer;
import model.Hall;
import model.Movie;

public class CinecartApp
{
    public static void main(String[] args)
    {
        Movie[] movies = CsvLoader.loadMovies("movies.csv");
        Hall[] halls = CsvLoader.loadHalls("halls.csv");
        ShowtimeBoard board = CsvLoader.loadShowtimes("showtimes.csv",movies,halls);
        ConcessionMenu menu = CsvLoader.loadConcessions("concessions.csv");
        Customer[] customers = CsvLoader.loadCustomers("customers.csv");
    }
}
