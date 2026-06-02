package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.Seat;
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

        Seat seat = s.getHall().getSeat(row, col);

        if(seat.isBooked()){
            System.out.println("Seat unavailable");
        }

        double price = s.getMovie().getBasePrice();
        if (seat.isPremium()) {
            price = price * 1.30;
        }
        if (s.isPeak()) {
            price = price * 1.20;
        }
    }
}