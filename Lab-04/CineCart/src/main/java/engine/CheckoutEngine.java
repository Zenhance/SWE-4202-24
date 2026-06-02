package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Ticket;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        if (board.findbyId(showtimeId) == null) return "Showtime not found";
        if (cart.getOwner().getAge() < board.findbyId(showtimeId).getMovie().getMinAge()) {
            return String.format("Underage for rating %s", board.findbyId(showtimeId).getMovie().getRating());
        }
        if (board.findbyId(showtimeId).getHall().getSeat(row,col).isBooked() == true)
            return "Seat unavailable";

        double price = board.findbyId(showtimeId).getMovie().getBasePrice()
                * (board.findbyId(showtimeId).getHall().getSeat(row, col).isPremium() ? 1.30 : 1.00)
                * (board.findbyId(showtimeId).isPeak() ? 1.20 : 1.00);

        board.findbyId(showtimeId).getHall().getSeat(row,col).book();

        Ticket t = new Ticket(board.findbyId(showtimeId), row, col, price);

        cart.addTicket(t);

        return "OK";
    }

    public String addConcession(Cart cart, String code, int qty) {
        if (menu.findByCode(code) == null) return "Item not found";
        if (qty <= 0) return "Invalid quantity";

        cart.addItem(menu.findByCode(code), qty);

        return "OK";
    }
}
