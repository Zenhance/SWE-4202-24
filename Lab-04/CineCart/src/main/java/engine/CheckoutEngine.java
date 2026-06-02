package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

import java.lang.String;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null)
            return "Showtime not found";
        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()) {
            String mod = String.format("Underage for rating <%s>", showtime.getMovie().getRating());
            return mod;
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if (seat.isBooked())
            return "Seat unavailable";

        double price = showtime.getMovie().getBasePrice()
                * ((seat.isPremium()? 1.30 : 1.00))
                * ((showtime.isPeak()? 1.20 : 1.00));
        seat.book();
        Ticket t = new Ticket(showtime,row,col,price);
        cart.addTicket(t);
    return "OK";
    }

    public String addConcession(Cart cart, String code, int qty){
        ConcessionItem item = menu.findByCode(code);
        if (item == null)
            return "Item not found";

        if (qty <= 0)
            return "Invalid quantity";
        cart.addItem(item,qty);
    return "OK";
    }

    double checkout(Cart cart){
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();
        double combo;
        if(cart.hasItem("POP") && cart.hasItem("SODA"))
            combo = 50.0;
        else combo = 0.0;

        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double group;
        if(cart.getTicketCount() >= 4)
            group = 0.10 * preDiscount;
        else group = 0.0;

        double tier;
        tier = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - group - tier;
        double tax = 0.05 * afterDiscounts;
        return Math.round((afterDiscounts + tax) * 100.0) / 100.0;
    }


}
