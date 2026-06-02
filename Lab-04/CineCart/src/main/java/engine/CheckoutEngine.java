package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Seat;
import model.Showtime;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine( ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }
     public  String bookTicket(Cart cart, int showtimeId, int row, int col){
    Showtime show = board.findById(showtimeId);
         if (show == null) {
             return " Showtime not found";
         }

         Seat seat = show.getHall().getSeat(row, col);
         if(!seat.isAvailable()){
             return "Seat unavailable";
         }


}
