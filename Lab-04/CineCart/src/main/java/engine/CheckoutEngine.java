package engine;
import data.ShowtimeBoard;
import data.ConcessionMenu;
import model.Cart;
import model.Showtime;
public class CheckoutEngine {
    ShowtimeBoard board;
    ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime show =
                board.findById(showtimeId);

        if (show == null) {
            return "Showtime not found";
        }
    }

      if(cart.getOwner().getAge()
                < show.getMovie().getMinAge()) {

        return "Underage for rating "
                + show.getMovie().getRating();
    }

    Seat seat =
            show.getHall().getSeat(row, col);


        if(!seat.isAvailable()) {
        return "Seat unavailable";
    }


    double price =
            show.getMovie().getBasePrice();


        if(seat.isPremium()) {
        price *= 1.30;
    }

        if(show.isPeak()) {
        price *= 1.20;
    }

          seat.book();

    Ticket t =
            new Ticket(show, row, col, price);

        cart.addTicket(t);

        return "OK";
}
}
