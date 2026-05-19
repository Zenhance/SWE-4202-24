package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;

public class CheckoutEngine {
    ShowtimeBoard board;
    ConcessionMenu menu;
    CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }
    String bookTicket(Cart cart, int showtimeId, int row, int col){
        if(board.findById(showtimeId)==null) return "Showtime not found";

        if(cart.getOwner().getAge()<board.findById(showtimeId).getMovie().getMinAge()) return String.format("Underage for rating %s",);

    }

}
