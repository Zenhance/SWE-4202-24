package engine;

import data.ConcessionMenu;
import data.ShowtimeBoard;
import model.*;

public class CheckoutEngine {
    private ShowtimeBoard board;
    private ConcessionMenu menu;

    public CheckoutEngine(ShowtimeBoard board, ConcessionMenu menu){
        this.board = board;
        this.menu = menu;
    }
    public String bookTicket(Cart cart, int showtimeId, int row, int col) {
        Showtime showtime = board.findById(showtimeId);
        if (showtime == null){
            String error = "Showtime not found";
            return error;
        }

        Movie movie = showtime.getMovie();
        if (cart.getOwner().getAge() < showtime.getMovie().getMinAge()){
            String message = "Underage for rating " + movie.getRating();
            return message;
        }

        Seat seat = showtime.getHall().getSeat(row, col);
        if (!seat.isAvailable()){
            String S = "Seat unavailable";
            return S;
        }

        double price = movie.getBasePrice()
                * (seat.isPremium() ? 1.30 : 1.00)
                * (showtime.isPeak() ? 1.20 : 1.00);

        seat.book();
        Ticket ticket = new Ticket(showtime, row, col, price);
        cart.addTicket(ticket);

        return "OK";
    }

    public String addConcession(Cart cart, String code, int qty){
        if(menu.findByCode(code) == null){
            String message = "Item not found";
            return message;
        }
        if(qty <= 0){
            String message2 = "Invalid quantity";
            return message2;
        }
        else{
            cart.addItem(menu.findByCode(code), qty);
        }
        return "OK";
    }

//    public double checkout(Cart cart){
//        double ticketSubtotal = cart.sumTicketsPaid();
//        double concessionSubtotal = cart.sumConcessionsRaw();
////        if(cart.hasItem())
//    }
//
//    public String getReceipt(Cart cart){
//
//    }
}
