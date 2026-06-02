package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Seat;
import model.Showtime;
import model.Ticket;

import java.lang.String;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null)
            return "Showtime not found";
        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()) {
            String mod = String.format("Underage for rating <%s>", showtime.getMovie().getRating());
            return mod;
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if (seat.isBooked())
            return "Seat unavailable";

        double price = showtime.getMovie().getBasePrice()
                * ((seat.isPremium()? 1.30 : 1.00))
                * ((showtime.isPeak()? 1.20 : 1.00));
        seat.book();
        Ticket t = new Ticket(showtime,row,col,price);
        cart.addTicket(t);
    return "OK";
    }


}
