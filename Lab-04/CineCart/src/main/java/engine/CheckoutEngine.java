package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;

import model.ConcessionItem;
import model.Showtime;
import model.Seat;
import model.Customer;
import model.Hall;
import model.Movie;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    // Implementing E.1 bookTicket
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        // [1]
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null) return "Showtime not found";


    }
}