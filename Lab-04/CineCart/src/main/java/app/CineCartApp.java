package app;

import io.CsvLoader;
import model.*;
import data.*;
import engine.CheckoutEngine;

public class CineCartApp {
    public static void main(String[] args) {
        Movie[] movies = CsvLoader.loadMovies("movies.csv");
        Hall[] halls = CsvLoader.loadHalls("halls.csv");

    }