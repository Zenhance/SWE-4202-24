package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null){
            String error = "Showtime not found";
            return error;
        }

        Movie movie = showtime.getMovie();
        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()){
            String message = "Underage for rating " + movie.getRating();
            return message;
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if (!seat.isAvailable()) return "Seat unavailable";

        double price = movie.getBasePrice()
                * (seat.isPremium() ? 1.30 : 1.00)
                * (showtime.isPeak() ? 1.20 : 1.00);

        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

        return "OK";
    }
}
