package engine;

import data.ShowtimeBoard;
import model.Showtime;
import model.Customer;
import model.ConcessionItem;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionItem menu;


    public CheckoutEngine(ShowtimeBoard board, ConcessionItem menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime showtime = board.findById(showtimeId);
        if(showtime == null){
            return "Showtime not found";
        }

        Movie movie = showtime.getMovie();
        if(cart.getOwner().getAge() < movie.getMinAge()){
            return "Underage for rating " + movie.getRating();
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if(!seat.isAvailable()){
            return "Seat unavailable";
        }

        double price = movie.getBasePrice() * (seat.isPremium() ? 1.30 : 1.00) * (showtime.isPeak() ? 1.20 : 1.00);

        seat.book();
        cart.addTicket(new Ticket(showtime, row, col, price));
        return "OK";
    }

    public String addConcession(Cart cart, String code, int qty){
        ConcessionItem item = menu.findByCode(code);
        if(item == null){
            return "Item not found";
        }
        if(qty <= 0){
            return "Invalid quantity";
        }
        cart.addItem(item, qty);
        return "OK";

    }
}
