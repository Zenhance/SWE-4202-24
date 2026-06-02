package engine;
import data.*;
import model.*;
public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    //constructor
    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col)
    Showtime showtime = board.findById(showtimeId){
        if (showtime == null) {
            return "Showtime not found";
        }
        Customer customer = cart.getOwner();
        if(customer.getAge()<showtime.getMovie().getMinAge()){
            return "Underage for rating" + showtime.getMovie().getRating();
        }
        Seat seat = showtime.getHall().getSeat(row,col);


    }
}