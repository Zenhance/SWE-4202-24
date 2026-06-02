package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Showtime;
import model.Cart;

public class CheckoutEngine {
    private final ShowtimeBoard board;
    private ConcessionMenu menu;
    public CheckoutEngine(ShowtimeBoard board,ConcessionMenu menu){
        this.board=board;
        this.menu=menu;
    }

    public String bookTicket(Cart cart,int showtimeId,int row,int col){
        return null;
    }


    public double checkout(Cart cart){
        return 123;
    }

    public String addReceipt(Cart cart) {
        return null;
    }

    public String addConcession(Cart cart, String code, int qty) {
        return null;
    }
}