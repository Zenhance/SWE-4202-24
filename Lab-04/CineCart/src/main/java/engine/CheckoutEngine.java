package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Ticket;

public class CheckoutEngine {
    private final ShowtimeBoard board;
    private final ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        if(board.findById(showtimeId)==null)
            return "Showtime not found";
        if(cart.getOwner().getAge()<board.findById(showtimeId).getMovie().getMinAge())
            return String.format("Underage for rating <%s>", board.findById(showtimeId).getMovie().getRating());
        if(board.findById(showtimeId).getHall().getSeat(row, col).isBooked())
            return "Seat unavailable";

        //price = movie.basePrice × (seat.isPremium ? 1.30 ∶ 1.00) × (showtime.isPeak() ? 1.20 ∶ 1.00).
        double price = (board.findById(showtimeId).getMovie().getBasePrice())*(board.findById(showtimeId).getHall().getSeat(row, col).isPremium()?1.30:1.00)*(board.findById(showtimeId).isPeak()?1.20:1.00);

        board.findById(showtimeId).getHall().getSeat(row, col).book();
        cart.addTicket(new Ticket(board.findById(showtimeId), row,col,price));

        return "OK";
    }

    public String addConcession(Cart cart, String code, int qty){
        if(menu.findByCode(code)==null)
            return "Item not found.";
        if(qty <= 0)
            return "Invalid quantity";

        cart.addItem(menu.findByCode(code),qty);
        return "OK";
    }

    double discount;

    public double checkout(Cart cart){
        double ticketSubtotal = cart.sumTicketsPaid();
        double concessionSubtotal = cart.sumConcessionsRaw();

        double combo = 0;
        if(cart.hasItem("POP")&& cart.hasItem("SODA")){
            combo = 50.00;
        }
        double preDiscount = ticketSubtotal + concessionSubtotal - combo;
        double group = 0;
        if(cart.getTicketCount()>=4)
            group= 0.10*preDiscount;

        double tier = cart.getOwner().getTierDiscount()*preDiscount;
        double afterDiscounts = preDiscount - group - tier;
        discount = group+tier;

        double tax = 0.05 * afterDiscounts;

        return Math.round(afterDiscounts+tax);
    }

    public String getReceipt(Cart cart){
        return String.format("Receipt:\nName: %s\nTotal: %f BDT\nDiscount: %f\n", cart.getOwner(),checkout(cart),discount);
    }
}

