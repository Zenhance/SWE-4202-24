package model;

public class StandardTicket extends AbstractTicket{
      public StandardTicket(Showtime showtime, int row, int col){
          super(showtime,row,col);
      }
      public double subtotal(){
             return basePrice*peak();
      }
      public String describe(){
          return "Standard Ticket";
      }
}
