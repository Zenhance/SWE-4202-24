package engine;
import model.Seat;
import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;
import model.Showtime;
import model.Ticket;

public class CheckoutEngine {
    ShowtimeBoard board;
    ConcessionMenu menu;
    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board=board;
        this.menu=menu;
    }
    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime showtime = board.findByID(showtimeId);
        if(showtime==null){
            return "Showtime not found";
        }
        if(cart.getOwner().getAge()<showtime.getMovie().getMinAge()){
            return "Underage for rating " + showtime.getMovie().getRating();
        }
        Seat seat = showtime.getHall().getSeat(row, col);
        if(!seat.isAvailable()){
            return "Seat unavailable";
        }
        double basePrice = showtime.getMovie().getBasePrice();
        double seatMultiplier = seat.isPremium() ? 1.30 : 1.00;
        double peakMultiplier = showtime.isPeak()?1.20:1.00;
        double finalPrice = basePrice*seatMultiplier*peakMultiplier;

        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, finalPrice);
        cart.addTicket(ticket);
        return "OK";
    }
    public String addConcession(Cart cart, String code, int qty){
        ConcessionItem item = menu.findByCode(code);
        if(item==null){
            return "Item not found";
        }
        if(qty<=0){
            return "Invalid quantity";
        }
        cart.addItem(item,qty);
        return "OK";
    }
    public double checkout(Cart cart){
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal=cart.sumConcessionraw();
        double combo=0.0;
        if(cart.hasItem("POP") && cart.hasItem("SODA")){
            combo=50.0;
        }
        double preDiscount=ticketSubtotal+concessionSubtotal-combo;

    }
}
