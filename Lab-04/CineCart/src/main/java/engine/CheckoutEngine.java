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
}

