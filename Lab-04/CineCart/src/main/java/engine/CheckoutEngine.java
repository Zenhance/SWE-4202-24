package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;
import model.LineItem;
import model.PremiumTicket;
import model.Seat;
import model.Showtime;
import model.StandardTicket;
import model.Ticket;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);

        if (showtime == null) {
            return "Showtime not found";
        }

        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()) {
            return "Underage for rating " + showtime.getMovie().getRating();
        }

        Seat seat = showtime.getHall().getSeat(row, col);

        if (!seat.isAvailable()) {
            return "Seat unavailable";
        }

        Ticket ticket;

        if (seat.isPremium()) {
            ticket = new PremiumTicket(showtime, row, col);
        } else {
            ticket = new StandardTicket(showtime, row, col);
        }

        seat.book();
        cart.add(ticket);

        return "OK";
    }

    public String addConcession(Cart cart, String code, int qty) {
        ConcessionItem item = menu.findByCode(code);

        if (item == null) {
            return "Item not found";
        }

        if (qty <= 0) {
            return "Invalid quantity";
        }

        cart.add(item, qty);
        return "OK";
    }

    public double checkout(Cart cart) {
        double subtotal = cart.grandSubtotal();

        double combo = 0.0;
        if (cart.hasCode("POP") && cart.hasCode("SODA")) {
            combo = 50.0;
        }

        double preDiscount = subtotal - combo;

        double group = 0.0;
        if (cart.ticketCount() >= 4) {
            group = 0.10 * preDiscount;
        }

        double tier = cart.getOwner().getTierDiscount() * preDiscount;

        double afterDiscounts = preDiscount - group - tier;
        double tax = 0.05 * afterDiscounts;

        return round2(afterDiscounts + tax);
    }

    public String getReceipt(Cart cart) {
        String receipt = "";
        receipt += "Receipt\n";
        receipt += "Customer: " + cart.getOwner().getName() + "\n";
        receipt += "--------------------\n";

        LineItem[] lines = cart.getLines();

        for (int i = 0; i < lines.length; i++) {
            receipt += lines[i].describe() + "\n";
        }

        double subtotal = cart.grandSubtotal();

        double combo = 0.0;
        if (cart.hasCode("POP") && cart.hasCode("SODA")) {
            combo = 50.0;
        }

        double preDiscount = subtotal - combo;

        double group = 0.0;
        if (cart.ticketCount() >= 4) {
            group = 0.10 * preDiscount;
        }

        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double discount = combo + group + tier;

        receipt += "--------------------\n";
        receipt += "Subtotal: BDT " + String.format("%.2f", subtotal) + "\n";
        receipt += "Discount: BDT " + String.format("%.2f", discount) + "\n";
        receipt += "Total: BDT " + String.format("%.2f", checkout(cart)) + "\n";

        return receipt;
    }

    private double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
