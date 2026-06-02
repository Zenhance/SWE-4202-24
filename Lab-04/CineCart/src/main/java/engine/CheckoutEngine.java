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

    // Implementing E.1 bookTicket
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        // [1]
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null) return "Showtime not found";

        // [2]
        Movie movie = showtime.getMovie();
        if (cart.getOwner().getAge() < movie.getMinAge()) {
            return String.format("Underage for rating <%s> ", movie.getRating());
        }

        // [3]
        Seat seat = showtime.getHall().getSeat(row, col);
        if (seat.isBooked()) return "Seat unavailable";

        // [4]
        double basePrice = movie.getBasePrice();
        double premiumMultiplier = seat.isPremium() ? 1.30 : 1.00;
        double peakMultiplier = showtime.isPeak() ? 1.20 : 1.00;

        double price = basePrice * premiumMultiplier * peakMultiplier;

        // [5]
        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

        // [6]
        return "OK";
    }

    // Implementing E.2 addConcession
    public String addConcession(Cart cart, String code, int qty) {
        ConcessionItem item = menu.findByCode(code);
        // [1]
        if (item == null) return null;

        // [2]
        if (qty <= 0) return "Invalid quantity";

        // [3]
        cart.addItem(item, qty);
        return "OK";
    }

    // F.1 checkout
    public double checkout(Cart cart) {

        // [1]
        double ticketSubtotal = cart.sumTicketsPaid();

        // [2]
        double concessionSubtotal = cart.sumConcessionsRaw();

        // [3]
        double combo = 0.0;
        if (cart.hasItem("SODA") && cart.hasItem("POP")) combo = 50.0;

        // [4]
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;

        // [5]
        double group = 0.0;
        if (cart.getTicketCount() >= 4) group = 0.10 * preDiscount;

        // [6]
        double tier = cart.getOwner().getTierDiscount() * preDiscount;

        // [7]
        double afterDiscounts = preDiscount - group - tier;

        // [8]
        double tax = 0.05 * afterDiscounts;
    }
}