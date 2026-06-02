package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    private Showtime s;
    private Movie m;
    private Ticket t;

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
     double price= m.getBasePrice()*(s.getH().getSeat(row, col).isPremium()?1.30:1.00)*(s.isPeak()?1.20:1.00);
     s.getH().getSeat(row, col).isBooked();
     Ticket t=new Ticket(s,row,col,price);
     cart.addTicket(t);

     return "OK";

    }
   public String addConcession(Cart cart,String code,int qty){
      menu.findByCode(code);
      if (menu.findByCode(code)==null)return "Item not found";
      if (qty<=0)return "Invalid quantity";
       ConcessionItem c=new ConcessionItem(code,, cart.getItemCount()).getUnitPrice();
      cart.addItem(c,qty);
      return "OK";
   }
   public double checkout(Cart cart){
      double ticketSubtotal=cart.sumTicketsPaid();
     double concessionSubtotal= cart.sumConcessionsRaw();
     if (cart.hasItem("POP")&& cart.hasItem("SODA"))
   }
}
