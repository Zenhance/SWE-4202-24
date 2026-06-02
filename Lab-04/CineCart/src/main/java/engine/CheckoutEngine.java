package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board=board;
        this.menu=menu;

    }

    public ShowtimeBoard getBoard() {
        return board;
    }

    public ConcessionMenu getMenu() {
        return menu;
    }
    public String bookTicket(Cart cart, int showTimeId, int row, int col){
        Showtime showtime=board.findById(showTimeId);
        if(showtime == null){
            return "Showtime not Found";
        }
        Movie movie=showtime.getMovie();
        if(cart.getOwner().getAge()<movie.getMinAge()){
            return "Underage for rating"+movie.getRating();

        }
        Seat seat=showtime.getHall().getSeat(row, col);
        if(!seat.isAvailable()){
            return "Seat unavailable";
        }
        double price=movie.getBasePrice()*(seat.isPremium()?1.30:1.00)*(showtime.isPeak()?1.20:1.00);
        seat.book();
        Ticket ticket=new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);
        return "OK";

    }

}
