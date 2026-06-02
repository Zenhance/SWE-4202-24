package engine;

import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board=board;
        this.menu=menu;
    }

    public String bookTicket(Cart cart,int showtimeId,int row,int col){
        Showtime showtime=board.findById(showtimeId);
        if (showtime == null) {
            String nf="Showtime not found";

            return nf;
        }
        if(cart.getOwner().getAge()<showtime.getMovie().getMinAge()){
            return "Underage for rating "+ showtime.getMovie().getRating();
        }
    }
}
