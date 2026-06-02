package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;
import model.Seat;
import model.Showtime;
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
        if (showtime == null)
            return "Showtime not found";

        int minAge = showtime.getMovie().getMinAge();
        if (cart.getOwner().getAge() < minAge) {
            return "Underage for rating " + showtime.getMovie().getRating();
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if (seat == null)
            return "Invalid seat coordinate";
        if (seat.isBooked())
            return "Seat unavailable";

        double price = showtime.getMovie().getBasePrice();
        if (seat.isPremium())
            price *= 1.30;
        if (showtime.isPeak())
            price *= 1.20;

        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

        return "OK";
    }

    public String addConcession(Cart cart, String code, int qty) {
        ConcessionItem item = menu.findByCode(code);
        if (item == null)
            return "Item not found";
        if (qty <= 0)
            return "Invalid quantity";

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
        return Math.round((afterDiscounts + tax) * 100.0) / 100.0;
    }
    public String getReceipt(Cart cart) {
        StringBuilder sb = new StringBuilder();
        sb.append("---  Receipt ---\n");
        sb.append("Customer: ").append(cart.getOwner().getName()).append("\n");

        sb.append("\nTickets:\n");
        Ticket[] t = cart.getTickets();
        for (int i = 0; i < cart.getTicketCount(); i++) {
            sb.append(t[i].toString()).append("\n");
        }

        sb.append("\nConcessions:\n");
        ConcessionItem[] ci = cart.getItems();
        int[] qtys = cart.getQtys();
        for (int i = 0; i < cart.getItemCount(); i++) {
            sb.append(qtys[i]).append("x ").append(ci[i].getName())
                    .append(" @ ").append(ci[i].getUnitPrice()).append("\n");
        }

        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();
        double combo = (cart.hasItem("POP") || cart.hasItem("SODA")) ? 50.0 : 0.0;
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double group = (cart.getTicketCount() > 4) ? 0.10 * preDiscount : 0.0;
        double tier = cart.getOwner().getTierDiscount() * preDiscount;
        double discountTotal = combo + group + tier;
        sb.append("\nDiscount Applied: ").append(Math.round(discountTotal)).append("\n");
        sb.append("Total: BDT ").append(String.format("%d", checkout(cart))).append("\n");
        sb.append("---------------");
        return sb.toString();
    }
    public static void main(String[] args) {
        ShowtimeBoard sb = new ShowtimeBoard();
        ConcessionMenu cm = new ConcessionMenu();
        CheckoutEngine engine = new CheckoutEngine(sb, cm);
        System.out.println("Testing CheckoutEngine Initialization:");
        System.out.println("Engine ready for bookings.");
    }

}