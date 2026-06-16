package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

//    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
//        if (board.findById(showtimeId) == null) return "Showtime not found";
//        if (cart.getOwner().getAge() < board.findById(showtimeId).getMovie().getMinAge()) {
//            return String.format("Underage for rating %s", board.findById(showtimeId).getMovie().getRating());
//        }
//        if (board.findById(showtimeId).getHall().getSeat(row,col).isBooked() == true)
//            return "Seat unavailable";
//
//        double price = board.findById(showtimeId).getMovie().getBasePrice()
//                * (board.findById(showtimeId).getHall().getSeat(row, col).isPremium() ? 1.30 : 1.00)
//                * (board.findById(showtimeId).isPeak() ? 1.20 : 1.00);
//
//        board.findById(showtimeId).getHall().getSeat(row,col).book();
//
//        Ticket t = new Ticket(board.findById(showtimeId), row, col, price);
//
//        cart.addTicket(t);
//
//        return "OK";
//    }
//
//    public String addConcession(Cart cart, String code, int qty) {
//        if (menu.findByCode(code) == null) return "Item not found";
//        if (qty <= 0) return "Invalid quantity";
//
//        cart.addItem(menu.findByCode(code), qty);
//
//        return "OK";
//    }
//
//    public double checkout(Cart cart) {
//        double ticketSubtotal = cart.sumTicketsPaid();
//        double concessionSubtotal = cart.sumConcessionsRaw();
//        double combo;
//        if (cart.hasItem("POP") && cart.hasItem("SODA")) combo = 50.0;
//        else combo = 0.0;
//
//        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
//
//        double group;
//        if (cart.getTicketCount() >= 4)  group = 0.10 * preDiscount;
//        else group = 0.0;
//
//        double tier = cart.getOwner().getTierDiscount() * preDiscount;
//
//        double afterDiscounts = preDiscount - group - tier;
//        double tax = 0.05 * afterDiscounts;
//
//        double round = afterDiscounts + tax;
//
//        return Math.round(round * 100.0) / 100.0;
//    }
//
//    public String getReceipt(Cart cart) {
//        return String.format("Receipt\n" +
//                "%s" +
//                "Total" +
//                "BDT" +
//                "Discount",
//                cart.getOwner().getName());
//    }

    public double checkout(Cart cart) {
        return 0.0;
    }

}
