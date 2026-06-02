package engine;
import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.Cart;
import model.ConcessionItem;
import model.Customer;
import model.Movie;
import model.Seat;
import model.Showtime;
import model.Ticket;

public class CheckoutEngine {
    ShowtimeBoard board;
    ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime show = board.findById(showtimeId);
        if (show == null) {
            return "Showtime not found";
        }
      if(cart.getOwner().getAge() < show.getMovie().getMinAge()) {
        return "Underage for rating "
                + show.getMovie().getRating();
    }
    Seat seat = show.getHall().getSeat(row, col);
        if(!seat.isAvailable()) {return "Seat unavailable";}
    double price = show.getMovie().getBasePrice();
        if(seat.isPremium()) {price *= 1.30;}
        if(show.isPeak()) {price *= 1.20;}
          seat.book();
        Ticket t = new Ticket(show, row, col, price);
        cart.addTicket(t);
        return "OK";
}

public String addConcession(Cart cart, String code, int qty){
        ConcessionItem item = menu.findByCode(code);
        if(item== null){
            return "Item not found";
        }
        if(qty<=0){
            return "Invalid quantity";
        }
        else{
            cart.addItem(item,qty);
            return "OK";
        }
}

public double checkout(Cart cart){
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionRaw();
        double combo = 0.0;
        if(cart.hasItem("POP") && cart.hasItem("SODA")){
            combo = 50.0;
        }
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double grp = 0;
        if(cart.getTicketCount()>=4){
            grp = 0.10* preDiscount;
        }
        double tier = cart.getOwner().getTierDiscount()*preDiscount;
        double afterDiscounts = preDiscount - grp - tier;
        double tax = 0.05 * afterDiscounts;
        double total = afterDiscounts+tax;
        return Math.round(total*100.0)/100.0;
}


}
