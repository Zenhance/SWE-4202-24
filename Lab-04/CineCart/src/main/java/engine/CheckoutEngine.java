package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Showtime;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board,ConcessionMenu menu){
        this.board=board;
        this.menu=menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        return "OK";
    }

    public String addConcession(Cart cart,String code, int qty){
        return "OK";
    }

    public double checkout(Cart cart){
        return 0.00;
    }

    public String getReceipt(Cart cart){
        return "idk";
    }
}
