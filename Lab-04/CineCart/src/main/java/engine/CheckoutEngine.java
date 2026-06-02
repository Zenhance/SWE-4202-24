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



}
      Seat seat =Showtime.getHall().getSeat(row,col);

 if(!seat.isAvailable())

    {
        return "Seat unavailable";
    }
 double price=movie.getBasePrice(){
 if(seat.isPremium()){
     price=price*1.30;
 }
  if(showtime.isPeak()){
      price=price*1.20;
  }
  seat.book();
  Ticket ticket=new Ticket(Showtime,row,col,price);
  Cart.addTicket(ticket);


}
 public String addConcession(Cart cart,String code,int qty){
     ConcessionItem iem=menu.findByCode(code);


}