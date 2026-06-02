package app;
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
        }
    }
}
