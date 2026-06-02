package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu) {
        this.board = board;
        this.menu = menu;
    }

    public String bookTicket(Cart cart, int showtimeId, int row, int col){
        Showtime s = (board.findById(showtimeId));

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

        seat.book();

        Ticket ticket = new Ticket (s, row, col, price);

        cart.addTicket(ticket);

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