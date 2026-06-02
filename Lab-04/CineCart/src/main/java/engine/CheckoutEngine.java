package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

import static java.lang.Math.round;

public class CheckoutEngine {
    ShowtimeBoard board;
    ConcessionMenu menu;
    public double discount=0;
    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }
    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        if(board.findById(showtimeId)==null) return "Showtime not found";
        Showtime show=board.findById(showtimeId);
        if(cart.getOwner().getAge()<show.getMovie().getMinAge()) return String.format("Underage for rating %s",show.getMovie().getRating());
        if(show.getHall().getSeat(row, col).isAvailable()) return "Seat unavailable";
        Seat seat=show.getHall().getSeat(row, col);
        double price= show.getMovie().getBasePrice()*(seat.isPremium?1.30:1.0)*(show.isPeak()?1.2:1.0);
        seat.book();
        Ticket t=new Ticket(show,row,col,price);
        return "OK";
    }
    public String addConcession(Cart cart, String code, int qty){

        if(menu.findByCode(code)==null) return "Item not found";
        if(qty<=0) return "Invalid quantity";
        cart.addItem(menu.findByCode(code),qty);
        return "OK";
    }
    public double checkout(Cart cart){
        double ticketSubTotal=cart.sumTicketsPaid();
        double concessionSubtotal=cart.sumConcessionsRaw();
        double combo= (cart.hasItem("POP")&& cart.hasItem("SODA"))?50:0;
        double preDiscount = ticketSubTotal + concessionSubtotal- combo;
        double group=0;
        if(cart.getTicketCount()>=4) group = 0.10 * preDiscount;
        double Tier_discount= cart.getOwner().getTierDiscount()*preDiscount;
        discount= group+Tier_discount;
        double afterDiscounts = preDiscount-discount;
        double tax=  0.05 * afterDiscounts;
        return round(afterDiscounts+tax);
    }
    public String getReceipt(Cart cart){
        return String.format("Receipt %s Total:BDT %.2f Discount: %.2f",cart.getOwner().getName(),checkout(cart),discount);

    }

}
