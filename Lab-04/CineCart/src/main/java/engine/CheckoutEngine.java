package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {


    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu  = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {


        Showtime showtime = board.findById(showtimeId);
        if (showtime == null) {
            return "Showtime not found";
        }


        Movie movie = showtime.getMovie();
        int customerAge = cart.getOwner().getAge();
        if (customerAge < movie.getMinAge()) {
            return "Underage for rating " + movie.getRating();
        }


        Seat seat = showtime.getHall().getSeat(row, col);
        if (!seat.isAvailable()) {
            return "Seat unavailable";
        }

        double price = movie.getBasePrice();

        if (seat.getIsPremium()) {
            price = price * 1.30;
        }

        if (showtime.isPeak()) {
            price = price * 1.20;
        }


        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

        return "OK";
    }
}