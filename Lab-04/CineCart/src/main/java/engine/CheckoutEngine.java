package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Showtime;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime showtime = board.findById(showtimeId);
        if(showtime == null) return "Showtime not found";

        int age = cart.getOwner().getAge();
        int req_age = showtime.getMovie().getMinAge();
        if(age<req_age){
            String rating = showtime.getMovie().getRating();
            String msg = "Underage for rating <"+rating+">";
            return msg;
        }
    }
}
