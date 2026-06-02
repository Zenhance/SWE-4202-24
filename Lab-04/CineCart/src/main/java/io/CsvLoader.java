package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import model.ConcessionItem;
import model.Customer;
import model.Hall;
import model.Movie;
import model.Showtime;
import data.ConcessionMenu;
import data.ShowtimeBoard;

/**
 * <p>
 * Provided to students. DO NOT MODIFY this file.
 * <p>
 * Each method takes a resource name (e.g. "movies.csv") and returns a fully
 * populated array or container. Files are expected to have a header row.
 */
public final class CsvLoader {

    private CsvLoader() { }

    public static Movie[] loadMovies(String resource) {
        try (BufferedReader br = open(resource)) {
            br.readLine(); // header
            Movie[] tmp = new Movie[100];
            int n = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] f = line.split(",");
                int    id           = Integer.parseInt(f[0].trim());
                String title        = f[1].trim();
                String rating       = f[2].trim();
                int    durationMin  = Integer.parseInt(f[3].trim());
                double basePrice    = Double.parseDouble(f[4].trim());
                tmp[n++] = new Movie(id, title, rating, durationMin, basePrice);
            }
            return trim(tmp, n);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + resource, e);
        }
    }

    public static Hall[] loadHalls(String resource) {
        try (BufferedReader br = open(resource)) {
            br.readLine();
            Hall[] tmp = new Hall[100];
            int n = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] f = line.split(",");
                int id          = Integer.parseInt(f[0].trim());
                int rows        = Integer.parseInt(f[1].trim());
                int cols        = Integer.parseInt(f[2].trim());
                int premiumRows = Integer.parseInt(f[3].trim());
                tmp[n++] = new Hall(id, rows, cols, premiumRows);
            }
            return trimHalls(tmp, n);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + resource, e);
        }
    }

    public static ShowtimeBoard loadShowtimes(String resource, Movie[] movies, Hall[] halls) {
        ShowtimeBoard board = new ShowtimeBoard();
        try (BufferedReader br = open(resource)) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] f = line.split(",");
                int id        = Integer.parseInt(f[0].trim());
                int movieId   = Integer.parseInt(f[1].trim());
                int hallId    = Integer.parseInt(f[2].trim());
                int startHour = Integer.parseInt(f[3].trim());
                String dateTag = f[4].trim();
                Movie m = findMovie(movies, movieId);
                Hall  h = findHall (halls,  hallId);
                if (m == null) throw new RuntimeException(
                        "Showtime " + id + " refers to unknown movieId " + movieId);
                if (h == null) throw new RuntimeException(
                        "Showtime " + id + " refers to unknown hallId " + hallId);
                board.add(new Showtime(id, m, h, startHour, dateTag));
            }
            return board;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + resource, e);
        }
    }

    public static ConcessionMenu loadConcessions(String resource) {
        ConcessionMenu menu = new ConcessionMenu();
        try (BufferedReader br = open(resource)) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] f = line.split(",");
                String code      = f[0].trim();
                String name      = f[1].trim();
                double unitPrice = Double.parseDouble(f[2].trim());
                menu.add(new ConcessionItem(code, name, unitPrice));
            }
            return menu;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + resource, e);
        }
    }

    public static Customer[] loadCustomers(String resource) {
        try (BufferedReader br = open(resource)) {
            br.readLine();
            Customer[] tmp = new Customer[100];
            int n = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] f = line.split(",");
                int    id   = Integer.parseInt(f[0].trim());
                String name = f[1].trim();
                int    age  = Integer.parseInt(f[2].trim());
                String tier = (f.length > 3 && !f[3].trim().isEmpty()) ? f[3].trim() : "BASIC";
                tmp[n++] = new Customer(id, name, age, tier);
            }
            return trimCustomers(tmp, n);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + resource, e);
        }
    }

    private static BufferedReader open(String resource) {
        ClassLoader cl = CsvLoader.class.getClassLoader();
        InputStream in = cl.getResourceAsStream(resource);
        if (in == null) {
            throw new RuntimeException("Resource not found on classpath: " + resource);
        }
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
    }

    private static Movie[] trim(Movie[] src, int n) {
        Movie[] out = new Movie[n];
        System.arraycopy(src, 0, out, 0, n);
        return out;
    }

    private static Hall[] trimHalls(Hall[] src, int n) {
        Hall[] out = new Hall[n];
        System.arraycopy(src, 0, out, 0, n);
        return out;
    }

    private static Customer[] trimCustomers(Customer[] src, int n) {
        Customer[] out = new Customer[n];
        System.arraycopy(src, 0, out, 0, n);
        return out;
    }

    private static Movie findMovie(Movie[] arr, int id) {
        for (Movie m : arr) if (m != null && m.getId() == id) return m;
        return null;
    }

    private static Hall findHall(Hall[] arr, int id) {
        for (Hall h : arr) if (h != null && h.getId() == id) return h;
        return null;
    }
}
