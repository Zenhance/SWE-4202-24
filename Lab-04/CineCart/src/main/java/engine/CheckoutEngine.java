package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        if (board.findbyId(showtimeId) == null) return "Showtime not found";
        if (cart.getOwner().getAge() < board.findbyId(showtimeId).getMovie().getMinAge()) {
            return String.format("Underage for rating %s", board.findbyId(showtimeId).getMovie().getRating());
        }
        if (board.findbyId(showtimeId).getHall().getSeat(row,col).isBooked() == true)
            return "Seat unavailable";

        return "OK";
    }
}
