package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Showtime;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime s = (board.findByID(showtimeId));

        if(s == null){
            System.out.println("Showtime not found");
        }

        int minAge = s.getMovie().getMinAge();

        if(cart.getOwner().getAge() < minAge){
            String.format("Underage for rating <%s>", s.getMovie().getRating());

        }
    }
}