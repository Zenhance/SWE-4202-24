package engine;

import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.Cart;
import model.Showtime;
import model.Seat;

public class CheckoutEngine{
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board=board;
        this.menu=menu;
    }
    String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);
        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()) {
            return "Underage for rating " + showtime.getMovie().getRating();
        }
        Seat seat = showtime.getHall().getSeat(row, col);
        if (seat.isBooked()) {
            return "Seat unavailable";
        }

        return "x";
    }

}

