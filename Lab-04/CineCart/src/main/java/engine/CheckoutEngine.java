package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Showtime;
import model.AbstractTicket;
import model.Cart;
import model.ConcessionItem;


public class CheckoutEngine {

    private ShowtimeBoard board;
    private ConcessionMenu menu;
    public CheckoutEngine(ShowtimeBoard  board, ConcessionMenu menu) {

        this.board = board;
        this.menu = menu;}

    public String bookTicket(Cart cart, int showtimeId, int row, int col){

        Showtime showtime = board.findById(showtimeId);

        return "OK";



    }


    public String addConcession(Cart cart, String code, int qty){
        ConcessionItem item = menu.findByCode(code);


return "OK";

    }

    public double checkout(Cart cart){

        double res=0.0;
        return res;


    }

    public String getReceipt(Cart cart){
        return "Receipt" + "BDT" + "Total" + "Discount";



    }

}
