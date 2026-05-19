package engine;

import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionItem menu;


    public CheckoutEngine(ShowtimeBoard board, ConcessionItem menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        if(board.findById(showtimeId) == null){
            return "Showtime Not Found";
        }

    }
}
