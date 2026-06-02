package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
  private ShowtimeBoard board;
  private ConcessionMenu menu;

  CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
      this.board=board;
      this.menu=menu;
  }

  String bookTicket(Cart cart, int showtimeId, int row, int col){
   Showtime found=board.findById(showtimeId);   /*This was initally shown wrong as, the board couldnt
                                                find the findById as it was package private. after i made the methods inside the
                                                Showtimeboard public, the erorr got fixed*/
      if(found==null){
          String res="Showtime Not Found!";
          return res;
      }

      int customerAge =cart.getOwner().getAge();
      int minAge= found.getMovie().getMinAge();
      String rating=found.getMovie().getRating();
      if(customerAge<minAge){
           return String.format("Underage for rating <%s>", rating);

      }

      if(found.getHall().getSeat(row, col).isBooked()){
          return "Seat unavailable";
      }

      double price_value=(found.getMovie().getBasePrice());
      double premiumValue=(found.getHall().getSeat(row,col).isPremium()?1.30:1.00);
      double peakValue=(found.isPeak(found.getStartHour())?1.20:1.00);

      double basePrice=price_value*premiumValue*peakValue;

      found.getHall().getSeat(row,col).book();

      Ticket t = new Ticket(found,row, col, basePrice );

      return "OK";


  }

    String addConcession(Cart cart, String code, int qty){
        ConcessionItem item=menu.findByCode(code);
        if(item==null){
            System.out.println("Item not found");
        }

        if(qty<=0){
            System.out.println("Invalid Quantity");
        }


    }
}
