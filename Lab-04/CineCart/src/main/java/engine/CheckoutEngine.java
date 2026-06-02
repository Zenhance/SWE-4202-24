package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Showtime;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    private Showtime s;

  public CheckoutEngine(ShowtimeBoard board,ConcessionMenu menu){
      this.menu=menu;
      this.board=board;
  }


    public String bookTicket(Cart cart,int showtimeId,int row,int col) {
      board.findbyId(showtimeId);
      if (board.findbyId(showtimeId)==null) return "Showtime not found";
      if (cart.getOwner().getAge()<s.getM().getMinAge()) return "Underage for rating "+s.getM().getRating() ;
      s.getH().getSeat(row, col);
      if (s.getH().getSeat(row, col).isBooked())return "Seat unavailable";
      int price=m

    }
}
