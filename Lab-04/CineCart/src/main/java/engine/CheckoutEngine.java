package engine;

import data.ShowtimeBoard;
import data.ConcessionMenu;
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
        int minAge = showtime.getMovie().getMinAge();

        if (customerAge < minAge) {
            return "Underage for rating " + showtime.getMovie().getRating();
        }

        Seat seat = showtime.getHall().getSeat(row, col);

        if (seat.isBooked()) {
            return "Seat unavailable";
        }

        double price = showtime.getMovie().getBasePrice();

        if (seat.isPremium()) {
            price *= 1.30;
        }

        if (showtime.isPeak()) {
            price *= 1.20;
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

        double combo;
        if (cart.hasItem("POP") && cart.hasItem("SODA")) {
            combo = 50.0;
        } else {
            combo = 0.0;
        }

        double preDiscount = ticketSubtotal + concessionSubtotal - combo;

        double group;
        if (cart.getTicketCount() >= 4) {
            group = 0.10 * preDiscount;
        } else {
            group = 0.0;
        }

        double tier = cart.getOwner().getTierDiscount() * preDiscount;

        double afterDiscounts = preDiscount - group - tier;
        double tax = 0.05 * afterDiscounts;

        return round2(afterDiscounts + tax);
    }

    private double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    private double calculateDiscount(Cart cart) {
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

        return combo+group+tier;
    }

    public String getReceipt(Cart cart){
        String reciept ="";


        reciept += "Concessions:\n";
            for (int i = 0; i < cart.getItemCount(); i++) {
                reciept+= cart.getItems()[i].getName()
                        + " x " + cart.getQtys()[i] + " = BDT " + String.format("%.2f", cart.getItems()[i].getUnitPrice() * cart.getQtys()[i]) + "\n";
            }
            double discount = calculateDiscount(cart);

            reciept += "Discount: BDT " + String.format("%.2f", discount) + "\n";
            reciept += "Total: BDT " + String.format("%.2f", checkout(cart)) + "\n";

            return reciept;
        }

}