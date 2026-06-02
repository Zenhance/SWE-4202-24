package engine;

import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.Cart;
import model.Showtime;
import model.Seat;
import model.Ticket;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        if (board.findById(showtimeId) == null) return "Showtime not found";
        if (cart.getOwner().getAge() < board.findById(showtimeId).getMovie().getMinAge()) {
            return "Underage for rating" + board.findById(showtimeId).getMovie().getRating();
        }
        if (board.findById(showtimeId).getHall().getSeat(row, col).isBooked()) {
            return "Seat unavailable";
        }
        double price = board.findById(showtimeId).getMovie().getBasePrice() *(board.findById(showtimeId).getHall().getSeat(row, col).isPremium() ? 1.30 : 1.00)
                *(board.findById(showtimeId).isPeak() ? 1.20 : 1.00);
        Ticket t=new Ticket(board.findById(showtimeId), row, col, price);
        cart.addTicket(t);
        return "OK";
    }
}



