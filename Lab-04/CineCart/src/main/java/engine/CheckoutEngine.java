package engine;

import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board=board;
        this.menu=menu;
    }

    public String bookTicket(Cart cart,int showtimeId,int row,int col){
        Showtime showtime=board.findById(showtimeId);
        if (showtime == null) {
            String nf="Showtime not found";

            return nf;
        }
        Movie movie=showtime.getMovie();
        if(cart.getOwner().getAge()<movie.getMinAge()){
            return "Underage for rating "+ movie.getRating();
        }
        Hall hall=showtime.getHall();
        Seat seat=hall.getSeat(row,col);
        if(!seat.isBooked()){
            return "Seat is unavailable";
        }
        double basePrice=showtime.getMovie().getBasePrice();
        double premiumFactor=seat.isPremium() ? 1.30 : 1.00;
        double peakFactor=showtime.isPeak() ? 1.20 : 1.00;
        double price=basePrice*premiumFactor * peakFactor;
        seat.book();

        StandardTicket ticket=new StandardTicket(showtime,row,col);

        cart.add(ticket);
        return "OK";
    }
        public String addConcession(Cart cart,String code,int qty){
            ConcessionItem item = menu.findByCode(code);
            if (item==null) {
                return "Item not found";
            }
            if (qty<=0) {
                return "Invalid quantity";
            }
            cart.add(item, qty);
            return "OK";
        }
        public double checkout(Cart cart){
        return 1.0;
        }
        public String getReceipt(Cart cart){
        return "R";
        }
}
