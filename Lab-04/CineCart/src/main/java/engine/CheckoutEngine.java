package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.Cart;
import model.ConcessionItem;
import model.Seat;
import model.Showtime;
import model.Ticket;


public class CheckoutEngine {

    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime show = board.findById(showtimeId);
        if (show == null) {
            return "Showtime not found";
        }

        int customerAge = cart.getOwner().getAge();

        int minAge = show.getMovie().getMinAge();

        if (customerAge < minAge) {
            return "Underage for rating "
                    + show.getMovie().getRating();
        }
        Seat seat = show.getHall().getSeat(row, col);
        if (seat.isBooked()) {
            return "Seat unavailable";
        }
        double price = show.getMovie().getBasePrice();

        if (seat.isPremium()) {
            price = price * 1.30;
        }
        if (show.isPeak()) {
            price = price * 1.20;
        }
        seat.book();

        Ticket t = new Ticket(
                show,
                row,
                col,
                price
        );
        cart.addTicket(t);
        return "OK";
    }
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime show = board.findById(showtimeId);
        if (show == null) {
            return "Showtime not found";
        }

        int customerAge = cart.getOwner().getAge();

        int minAge = show.getMovie().getMinAge();

        if (customerAge < minAge) {
            return "Underage for rating "
                    + show.getMovie().getRating();
        }
        Seat seat = show.getHall().getSeat(row, col);
        if (seat.isBooked()) {
            return "Seat unavailable";
        }
        double price = show.getMovie().getBasePrice();

        if (seat.isPremium()) {
            price = price * 1.30;
        }
        if (show.isPeak()) {
            price = price * 1.20;
        }
        seat.book();

        Ticket t = new Ticket(
                show,
                row,
                col,
                price
        );
        cart.addTicket(t);
        return "OK";
    }
    public String addConcession(Cart cart,String code,int qty){
        ConcessionItem item=menu.findByCode(code);
        if(item==null){
            return "Item not found";
        }
        if(qty<=0){
            return "Invalid quantity";
        }
        cart.addItem(item,qty);
        return "OK";
    }
}