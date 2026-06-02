package engine;

import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.Cart;
public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board=board;
        this.menu=menu;
    }
    String bookTicket(Cart cart, int showtimeId, int row, int col){


        return "x";
    }
}
