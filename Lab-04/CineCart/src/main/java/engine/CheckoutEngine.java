package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

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
        double price = showtime.getMovie().getBasePrice()*(seat.isPremium()?1.30:1.00)*(showtime.isPeak()?1.20:1.00);
          seat.book();
        Ticket ticket=new Ticket(showtime,row,col,price);
        cart.addTicket(ticket);
        return "OK";
    }
    public String addConcession(Cart cart,String code,int qty){
        ConcessionItem item=menu.findByCode(code);
        if(item== null){
            return "Item not found";
        }
    }
}
