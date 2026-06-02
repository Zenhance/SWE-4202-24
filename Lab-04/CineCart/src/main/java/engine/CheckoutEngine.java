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
        Seat seat=showtime.getHall().getSeat(row,col);
        if(seat.isBooked()){
            return "Seat is unavailable";
        }
        if(showtime.getMovie().getBasePrice()*(seat.isPremium()==true)){
            double price=1.30*(showtime.isPeak() ? 1.20 : 1.00);
        }
        else{
            double price = 1.00*(showtime.isPeak() ? 1.20 : 1.00);
        }
        seat.book();
        Ticket ticket=new Ticket(showtime,row,col, double price);

        cart.addTicket(ticket);
        return "OK";
        String code;
        public String addConcession(Cart cart,code,int qty) {
            ConcessionItem item = menu.findByCode(code);
            if (item==null) {
                return "Item not found";
            }
            if (qty<=0) {
                return "Invalid quantity";
            }
            cart.addItem(item, qty);
            return "OK";
        }
}
