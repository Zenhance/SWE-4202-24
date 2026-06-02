package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;

public class CheckoutEngine {
    private ShowtimeBoard board;
    ConcessionMenu menu;
    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        if(board.findById(showtimeId)==null) return "Showtime not found";
        return "hello";
    }
    public String addConcession(Cart cart, String code, int qty){
        return "Hello";
    }
    public double checkout(Cart cart){
        return 0.0;
    }
    public String getReceipt(Cart cart){
        return "Hello";
    }
}
