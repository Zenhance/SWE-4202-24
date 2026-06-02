package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    //E.1
    String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime showtime = board.findById(showtimeId);
        if(showtime == null) return "Showtime not found";

        int age = cart.getOwner().getAge();
        int req_age = showtime.getMovie().getMinAge();
        if(age<req_age){
            String rating = showtime.getMovie().getRating();
            String msg = "Underage for rating <"+rating+">";
            return msg;
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if(seat.isBooked()) return "Seat unavailable";

        Movie movie = showtime.getMovie();
        double price = movie.getBasePrice() *
                (seat.isPremium() ? 1.30 : 1.00) *
                (showtime.isPeak() ? 1.20 : 1.00);

        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

        return "OK";
    }

    //E.2
    String addConcession(Cart cart, String code, int qty){
        ConcessionItem item = menu.findByCode(code);
        if(item == null) return "Item not found";

        if (qty <= 0) return "Invalid quantity";

        cart.addItem(item, qty);
        return "OK";
    }

    //F.1
    double checkout(Cart cart){
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();
        double combo = 0;
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double group = 0.10 * preDiscount;
        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - group - tier;
        double tax = 0.05 * afterDiscounts;
        double rounded;

        return null;
    }
}
