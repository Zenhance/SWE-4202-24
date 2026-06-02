package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;
import model.Seat;
import model.Showtime;
import model.Ticket;


public class CheckoutEngine {

    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }
}