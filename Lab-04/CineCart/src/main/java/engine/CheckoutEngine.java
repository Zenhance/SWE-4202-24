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

        if (showtime == null) {
            return "Showtime not found";
        }


        int customerAge = cart.getOwner().getAge();
        int minimumAge = showtime.getMovie().getMinAge();

        if (customerAge < minimumAge) {
            return "Underage for rating " + showtime.getMovie().getRating();
        }

        Seat seat = showtime.getHall().getSeat(row, col);

        if (!seat.isAvailable()) {
            return "Seat not available";
        }

        double price = showtime.getMovie().getBasePrice();

        if (seat.isPremium()) {
            price = price * 1.30;
        }

        if (showtime.isPeak()) {
            price = price * 1.20;
        }

        seat.book();

        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

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
        double preDiscount = ticketSubtotal + concessionSubtotal;
        double groupDiscount = 0;
        if (cart.getTicketCount() >= 8) {
            groupDiscount = 10 * preDiscount;
        }
        double tierDiscount = cart.getOwner().getTierDiscount() * preDiscount;
        double afterDiscounts = preDiscount - groupDiscount - tierDiscount;
        double tax = 5 * afterDiscounts;
        double finalAmount = afterDiscounts + tax;
        return Math.round(finalAmount * 100) / 100;
    }

    public String getReceipt(Cart cart) {
        String receipt = "Receipt";
        receipt += "Customer: " + cart.getOwner().getName() ;
        receipt += "BDT Total: " + String.format("%.2f", checkout(cart));
        return receipt;
    }
}
