package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Showtime;
import model.Ticket;
import model.Cart;
import


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


return "OK";

    }

}
