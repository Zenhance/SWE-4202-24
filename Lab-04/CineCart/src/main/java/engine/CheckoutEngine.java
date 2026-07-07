package engine;
import data.ConcessionMenu;
import model.cart;
import model.ticket;

public class CheckoutEngine {

    private ConcessionMenu menu;
    private ShowtimeBoard board;
    public CheckoutEngine (ConcessionMenu menu, ShowtimeBoard board){
        this.board = board;
        this.menu = menu;
    }
}