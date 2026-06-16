package engine;
import data.ShowtimeBoard;
 import data.ConcessionMenu;
  import model.*;
  
public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

 public CheckoutEngine(ShowtimeBoard board,ConcessionMenu menu){
     this.board=board;
     this.menu=menu;
 }
  public String bookTicket(Cart cart,int showtimeId,int row,int col){
       Showtime showtime=board.findById(showtimeId);

       if(showtime==null){
           return "Showtime not found";
       }
       Movie movie=showtime.getMovie();
       Customer customer=cart.getOwner();

          if (customer.getAge()< movie.getMinAge()) {
              return "Underage for rating" + movie.getRating();
          }




      Seat seat =showtime.getHall().getSeat(row,col);

 if(!seat.isAvailable())

    {
        return "Seat unavailable";
    }
 double price=movie.getBasePrice();
 if(seat.isPremium()){
     price=price*1.30;
 }
  if(showtime.isPeak()){
      price=price*1.20;
  }
  seat.book();
  Ticket ticket=new Ticket(showtime,row,col,price);
  cart.addTicket(ticket);
return "OK";
}
 public String addConcession(Cart cart,String code,int qty){
     ConcessionItem item=menu.findByCode(code);
     if(item==null){
         return "Item not found";
     }
     if(qty<=0){
         return "Invalid quantity";
     }
     cart.addItem(item,qty);
     return "OK";
}

    public double checkout(Cart cart) {
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionRaw();

        double combo;
        if (cart.hasItem("POP") && cart.hasItem("SODA")) {
            combo = 50.0;
        } else {
            combo = 0.0;
        }
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;

        double group;
        if (cart.getTicketCount() >= 4) {
            group = 0.10 * preDiscount;
        } else {
            group = 0.0;
        }
        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - group - tier;
        double tax = 0.05 * afterDiscounts;
        return round2(afterDiscounts + tax);
    }

    private double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public String getReceipt(Cart cart) {
        String result = " ";
        result += "____Receipt____\n";
        result += "Customer: " + cart.getOwner().getName() + "\n\n";
        result += "Tickets:\n";
        for (int i = 0; i < cart.getItemCount(); i++) {
            result += cart.getItems()[i].getName()+ "x" + cart.getQtys()[i] + "\n";
        }
        double total = checkout(cart);
        result += "\nDiscount applied\n";
        result+="Total:BDT " + String.format("%.2f",total) + "\n";
        return result;
    }
}
