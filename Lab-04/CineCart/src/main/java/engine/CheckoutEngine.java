package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;

import model.*;

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

        // [2]
        Movie movie = showtime.getMovie();
        if (cart.getOwner().getAge() < movie.getMinAge()) {
            return String.format("Underage for rating <%s> ", movie.getRating());
        }

        // [3]
        Seat seat = showtime.getHall().getSeat(row, col);
        if (seat.isBooked()) return "Seat unavailable";

        // [4]
        double basePrice = movie.getBasePrice();
        double premiumMultiplier = seat.isPremium() ? 1.30 : 1.00;
        double peakMultiplier = showtime.isPeak() ? 1.20 : 1.00;

        double price = basePrice * premiumMultiplier * peakMultiplier;

        // [5]
        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);
    }
}