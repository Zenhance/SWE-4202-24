package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Seat;
import model.Showtime;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    public CheckoutEngine(ShowtimeBoard board,ConcessionMenu menu){

        this.board=board;
        this.menu=menu;


    }
    public String bookTicket(Cart cart,int showtimeId,int row,int col) {
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null) {
            return "Showtime not found";
        }
        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()) {
            return "Underage for rating <" + showtime.getMovie().getRating() + ">";
        }
        Seat seat = showtime.getHall().getSeat(row, col);
          if(seat.isBooked()){
              return "Seat unavailable";
          }

    }
}
