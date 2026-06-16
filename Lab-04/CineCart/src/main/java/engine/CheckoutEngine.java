package engine;

import model.*;
import data.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;
    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime st = board.findById(showtimeId);
        if (st == null) {
            return "Showtime not found";
        }

        if (cart.getOwner().getAge() < st.getMovie().getMinAge()) {
            return "Underage for rating " + st.getMovie().getRating();
        }

        Seat seat = st.getHall().getSeat(row, col);
        if (!seat.isAvailable()) {
            return "Seat unavailable";
        }

        double price = st.getMovie().getBasePrice();
        if (seat.isPremium()) {
            price = price * 1.30;
        }
        if (st.isPeak()) {
            price = price * 1.20;
        }

        seat.book();
        Ticket t = new Ticket(st, row, col, price);
        cart.addTicket(t);
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

        cart.addItem(item, qty);
        return "OK";
    }
    public double checkout(Cart cart) {
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();
        double combo = 0.0;
        if (cart.hasItem("POP") && cart.hasItem("SODA")) {
            combo = 50.0;
        }
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double group = 0.0;
        if (cart.getTicketCount() >= 4) {
            group = 0.10 * preDiscount;
        }
        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - group - tier;
        double tax = 0.05 * afterDiscounts;
        double total = afterDiscounts + tax;
        return Math.round(total * 100.0) / 100.0;
    }
    public String getReceipt(Cart cart) {
        String result = "";
        result = result + "Receipt for " + cart.getOwner().getName() + "\n";
        result = result + "----------------------------------------\n";

        for (int i = 0; i < cart.getTicketCount(); i++) {
            result = result + cart.getTickets()[i].toString() + "\n";
        }

        for (int i = 0; i < cart.getItemCount(); i++) {
            ConcessionItem item = cart.getItems()[i];
            int qty = cart.getQtys()[i];
            result = result + String.format("%s x%d - BDT %.2f\n",
                    item.getName(), qty, item.getUnitPrice() * qty);
        }

        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();
        double combo = 0.0;
        if (cart.hasItem("POP") && cart.hasItem("SODA")) {
            combo = 50.0;
        }
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double group = 0.0;
        if (cart.getTicketCount() >= 4) {
            group = 0.10 * preDiscount;
        }
        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double totalDiscount = group + tier + combo;
        double finalTotal = checkout(cart);

        result = result + "----------------------------------------\n";
        result = result + String.format("Discount: BDT %.2f\n", totalDiscount);
        result = result + String.format("Total: BDT %.2f\n", finalTotal);

        return result;
    }
}
